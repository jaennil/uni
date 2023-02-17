import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TimerTask;
import java.util.Timer;

public class Field extends JFrame {
    public int rows, columns;
    private Cell[][] cells;
    public static final int WIDTH = 3200;
    public static final int HEIGHT = 2000;
    public static final int WINDOW_LOCATION_X = 0;
    public static final int WINDOW_LOCATION_Y = 0;

    public Field() {
        createCells();
        setBounds(WINDOW_LOCATION_X, WINDOW_LOCATION_Y, WIDTH, HEIGHT);
        setTitle("Game of life");
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameLoopTimer(1);
    }

    public void createCells() {
        // ArrayList<ArrayList<Byte>> field = fromFile("src/field.txt");
        ArrayList<ArrayList<Byte>> field = fromRandom(7000,  7000);
        this.rows = field.size();
        this.columns = field.get(0).size();
        Cell.SIZE = 1;
        this.cells = new Cell[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                cells[i][j] = new Cell(i, j, field.get(i).get(j) == 1);
            }
        }
    }

    public static ArrayList<ArrayList<Byte>> fromFile(String path) {
        ArrayList<ArrayList<Byte>> field = new ArrayList<>();
        try (FileReader fileReader = new FileReader(path)) {
            Scanner scanner = new Scanner(fileReader);
            String line;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                ArrayList<Byte> row = new ArrayList<>();
                for (int i = 0; i < line.length(); i++) {
                    row.add(Byte.parseByte(line.substring(i, i + 1)));
                }
                field.add(row);
            }
            scanner.close();
        } catch (FileNotFoundException exception) {
            System.out.println("ABORT: file not found " + path);
        } catch (IOException ioException) {
            System.out.println("ABORT: io exception");
        }
        return field;
    }

    private static ArrayList<ArrayList<Byte>> fromRandom(int rows, int columns) {
        ArrayList<ArrayList<Byte>> field = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            field.add(new ArrayList<Byte>());
            for (int j = 0; j < columns; j++) {
                field.get(i).add((byte)(Math.random() < 0.5 ? 0 : 1));
            }
        }
        return field;
    }

    public void gameLoopTimer(int period) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                gameLoop();
            }
        }, 0, period);
    }

    public void gameLoop() {
        // System.out.println("game loop");
        Cell[][] state = clone(cells);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // System.out.println("for");
                Cell cell = state[i][j];
                Cell newCell = cells[i][j];
                ArrayList<Cell> neighbors = getNeighbors(cell, state);
                ArrayList<Cell> aliveNeighbors = getAliveNeighbors(neighbors);
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