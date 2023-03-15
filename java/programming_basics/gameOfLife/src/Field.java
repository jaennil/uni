import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Timer;

public class Field extends JFrame {
    private Timer timer;
    public int rows, columns;
    private Cell[][] cells;
    private ArrayList<Cell[][]> states = new ArrayList<>();
    public static final int WIDTH = 3200, HEIGHT = 2000;
    public static final int WINDOW_SPAWN_X = 0, WINDOW_SPAWN_Y = 0;

    private static final Scanner scanner = new Scanner(System.in);

    private final int period = 1;

    public Field() {
        createCells();
        initWindow();
        createGameLoopTimer();
        startGameControlsHandler();
    }

    private void startGameControlsHandler() {
        while (true) {
            System.out.println("type \"stop\" to stop game, \"resume\" to resume game,\nincrease to increase cell size , decrease to decrease cell size");
            String input = scanner.nextLine();
            switch (input) {
                case "stop" -> timer.cancel();
                case "resume" -> createGameLoopTimer();
                case "increase" -> Cell.SIZE += 1;
                case "decrease" -> Cell.SIZE -= 1;
                default -> System.out.println("wrong command");
            }
        }
    }

    private void initWindow() {
        setBounds(WINDOW_SPAWN_X, WINDOW_SPAWN_Y, WIDTH, HEIGHT);
        setTitle("Game of life");
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createCells() {
        this.rows = promptRows();
        this.columns = promptColumns();
        ArrayList<ArrayList<Byte>> field = fromFile(promptPath());
//        ArrayList<ArrayList<Byte>> field = fromRandom(7000,  7000);
        int cellHeight = HEIGHT/columns;
        int cellWidth = WIDTH/rows;
        int cellSize = cellWidth < cellHeight ? cellWidth + 1 : cellHeight + 1;
        while (cellSize*rows > HEIGHT || cellSize * columns > WIDTH) {
            cellSize -= 1;
        }
        Cell.SIZE = cellSize;
        this.cells = new Cell[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                cells[i][j] = new Cell(i, j, false);
            }
        }
        int x = promptX();
        int y = promptY();
        for (int i = 0; i < field.size(); i++) {
            for (int j = 0; j < field.get(0).size(); j++) {
                try {
                    byte cellValue = field.get(i).get(j);
                    cells[i+y][j+x] = new Cell(i+y, j+x, cellValue == 1);
                } catch (Exception exc) {
                    cells[i+y][j+x] = new Cell(i+y, j+x, false);
                }
            }
        }
    }

    private int promptRows() {
        System.out.print("Enter amount of rows: ");
        String line = scanner.nextLine();
        return Integer.parseInt(line);
    }

    private int promptColumns() {
        System.out.print("Enter amount of columns: ");
        String line = scanner.nextLine();
        return Integer.parseInt(line);
    }

    private int promptX() {
        System.out.print("Enter x: ");
        String line = scanner.nextLine();
        return Integer.parseInt(line);
    }

    private int promptY() {
        System.out.print("Enter y: ");
        String line = scanner.nextLine();
        return Integer.parseInt(line);
    }

    private String promptPath() {
        System.out.print("Enter path to the file: ");
        return scanner.nextLine();
    }

    public static ArrayList<ArrayList<Byte>> fromFile(String path) {
        ArrayList<ArrayList<Byte>> field = new ArrayList<>();

        try (FileReader fileReader = new FileReader(path)) {
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                ArrayList<Byte> row = new ArrayList<>();
                for (int i = 0; i < line.length(); i++) {
                    row.add(Byte.parseByte(line.substring(i, i + 1)));
                }
                field.add(row);
            }
        } catch (FileNotFoundException exception) {
            System.out.println("ABORT: file not found at " + (path.isEmpty() ? "%path not provided%" : path));
            System.out.println("using default file at samples/glider.txt instead");
            return fromFile("samples/glider.txt");
        } catch (IOException ioException) {
            System.out.println("ABORT: io exception");
        }
        return field;
    }

    private static ArrayList<ArrayList<Byte>> fromRandom(int rows, int columns) {
        ArrayList<ArrayList<Byte>> field = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            field.add(new ArrayList<>());
            for (int j = 0; j < columns; j++) {
                field.get(i).add((byte)(Math.random() < 0.5 ? 0 : 1));
            }
        }
        return field;
    }

    public void createGameLoopTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                gameLoop();
            }
        }, 0, period);
    }

    public void gameLoop() {
        Cell[][] state = clone(cells);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Cell cell = state[i][j];
                ArrayList<Cell> neighbors = getNeighbors(cell, state);
                ArrayList<Cell> aliveNeighbors = getAliveNeighbors(neighbors);
                Cell newCell = cells[i][j];
                if (cell.isAlive()) {
                    if (aliveNeighbors.size() < 2 || aliveNeighbors.size() > 3) {
                        newCell.setDead();
                    }
                } else {
                    if (aliveNeighbors.size() == 3) {
                        newCell.setAlive();
                    }
                }
            }
        }
        states.add(state);
        checkEndGame();
    }

    private ArrayList<Cell> getAliveNeighbors(ArrayList<Cell> neighbors) {
        ArrayList<Cell> aliveNeighbors = new ArrayList<>();
        for (Cell neighbor : neighbors) {
            if (neighbor.isAlive()) {
                aliveNeighbors.add(neighbor);
            }
        }
        return aliveNeighbors;
    }

    private void checkEndGame() {
        if (allCellsDead()) {
            System.out.println("game end! all cells dead");
            timer.cancel();
        }
        if (stateNotChanged()) {
            System.out.println("game end! state not changed");
            timer.cancel();
        }
    }

    private boolean allCellsDead() {
        for (Cell[] row:
             cells) {
            for (Cell cell: row) {
                if (cell.isAlive()) return false;
            }
        }
        return true;
    }

    private boolean stateNotChanged() {
        if (states.isEmpty()) return false;
        if (states.size() == 1) return false;
        for (int i = 0; i < states.size()-1; i++) {
            if (equals(cells, states.get(i))) {
                return true;
            }
        }
        return false;
        // Cell[][] lastState = states.get(states.size() - 1);
        // return equals(lastState, cells);
    }

    private boolean equals(Cell[][] first, Cell[][] second) {
        if (first.length != second.length) return false;
        if (first[0].length != second[0].length) return false;
        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < first[0].length; j++) {
                if (first[i][j].isDead() && second[i][j].isAlive()) return false;
                if (first[i][j].isAlive() && second[i][j].isDead()) return false;
            }
        }
        return true;
    }

    private ArrayList<Cell> getNeighbors(Cell cell, Cell[][] cells) {
        ArrayList<Cell> neighbors = new ArrayList<>();
        for (int i = cell.i - 1; i <= cell.i + 1; i++) {
            for (int j = cell.j - 1; j <= cell.j + 1; j++) {
                // exclude cell itself
                if (j == cell.j && i == cell.i) {
                    continue;
                }
                int ni = i;
                int nj = j;
                if (i < 0) ni = rows - 1;
                if (j < 0) nj = columns - 1;
                if (i == rows) ni = 0;
                if (j == columns) nj = 0;
                neighbors.add(cells[ni][nj]);
            }
        }
        return neighbors;
    }

    private Cell[][] clone(Cell[][] cells) {
        Cell[][] new_cells = new Cell[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Cell cell = cells[i][j];
                new_cells[i][j] = new Cell(cell.i, cell.j, cell.isAlive());
            }
        }
        return new_cells;
    }

    @Override
    public void paint(Graphics graphics) {
        // super.paint(graphics);
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                cell.draw(graphics);
            }
        }
        repaint();
    }
}