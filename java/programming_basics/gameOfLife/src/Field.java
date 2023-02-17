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
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 1000;
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
        ArrayList<ArrayList<Byte>> field = fromFile("src/field.txt");
        this.rows = field.size();
        this.columns = field.get(0).size();
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

    private void print(Cell[][] cells, String label) {
        System.out.println("--- " + label + " ---");
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                System.out.print((cell.isAlive() ? 1 : 0) + " ");
            }
            System.out.println();
        }
    }

    private void print(ArrayList<Cell> row) {
        for (Cell cell : row) {
            System.out.println("i = " + String.valueOf(cell.i) + " j = " + String.valueOf(cell.j));
        }
    }

    private void printNeighbors(ArrayList<Cell> neighbors, int i, int j) {
        System.out.println("--- neighbors ---");
        System.out.println("cell: i = " + i + " j = " + j);
        print(neighbors);
    }

    private void printAliveNeighbors(ArrayList<Cell> aliveNeighbors, int i, int j) {
        System.out.println("--- alive neighbors ---");
        System.out.println("cell: i = " + i + " j = " + j);
        print(aliveNeighbors);
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
                // exclude cells outside the field
                // if (i < 0 || i == rows || j < 0 || j == columns) continue;
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