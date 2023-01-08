import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TimerTask;
import java.util.Timer;

public class Field extends JFrame {
    public int rows;
    public int columns;
    private Cell[][] cells;
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 1000;
    public static final int WINDOW_LOCATION_X = 0;
    public static final int WINDOW_LOCATION_Y = 0;
    static Scanner scan = new Scanner(System.in);

    public Field(ArrayList<ArrayList<Byte>> field) {
        this.rows = field.size();
        this.columns = field.get(0).size();
        createCells(field);
        setBounds(WINDOW_LOCATION_X, WINDOW_LOCATION_Y, WIDTH, HEIGHT);
        setTitle("Game of life");
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameLoopTimer(500);
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
        System.out.println("game loop");
        Cell[][] state = new Cell[rows][columns];
        for (int i = 0; i < rows; i++) {
            state[i] = cells[i].clone();
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Cell cell = state[i][j];
                Cell newCell = cells[i][j];
                ArrayList<Cell> neighbors = getNeighbors(cell);
                ArrayList<Cell> aliveNeighbors = getAliveNeighbors(neighbors);
                if (cell.isAlive()) {
                    if (aliveNeighbors.size() < 2 || aliveNeighbors.size() > 3) {
                        newCell.setAlive(false);
                    }
                } else {
                    if (aliveNeighbors.size() == 3) {
                        newCell.setAlive(true);
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

    private ArrayList<Cell> getNeighbors(Cell cell) {
        ArrayList<Cell> neighbors = new ArrayList<>();
        for (int i = cell.x - 1; i <= cell.x + 1; i++) {
            for (int j = cell.y - 1; j <= cell.y + 1; j++) {
                // exclude cell itself
                if (i == cell.x && j == cell.y) {
                    continue;
                }
                // exclude cells outside the field
                if (i < 0 || i >= rows || j < 0 || j >= columns) {
                    continue;
                }
                neighbors.add(cells[i][j]);
            }
        }
        return neighbors;
    }

    public void createCells(ArrayList<ArrayList<Byte>> field) {
        cells = new Cell[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // reversed because in array i = y, j = x. But in scene i = x, j = y
                cells[i][j] = new Cell(j, i, field.get(i).get(j) != 0);
                add(cells[i][j].button);
            }
        }
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        System.out.println("paint");
        repaint();
    }
}