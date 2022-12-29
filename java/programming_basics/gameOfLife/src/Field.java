import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Field extends JFrame {

    public int rows;

    public int columns;

    private JButton[][] cells;

    private ArrayList<ArrayList<Byte>> field;
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 1000;

    public static final int WINDOW_LOCATION_X = 200;

    public static final int WINDOW_LOCATION_Y = 200;

    public static final int CELL_SIZE = 20;

    public Field(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        cells = new JButton[rows][columns];

        System.out.println("generate");
        generate();
        setBounds(WINDOW_LOCATION_X, WINDOW_LOCATION_Y, WIDTH, HEIGHT);
        setTitle("game of life");
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Field(ArrayList<ArrayList<Byte>> field) {
        this.rows = field.size();
        this.columns = field.get(0).size();
        cells = new JButton[rows][columns];
        this.field = field;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.println(field.get(i).get(j));
                JButton button = new JButton();
                button.setBounds(j * CELL_SIZE+40, i * CELL_SIZE+50, CELL_SIZE, CELL_SIZE);
                button.setBackground(field.get(i).get(j) == 0 ? Color.WHITE : Color.BLACK);
                add(button);
                cells[i][j] = button;
            }
        }
        setBounds(WINDOW_LOCATION_X, WINDOW_LOCATION_Y, WIDTH, HEIGHT);
        setTitle("game of life");
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void generate() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                JButton button = new JButton();
                button.setBounds(i * CELL_SIZE+40, j * CELL_SIZE+50, CELL_SIZE, CELL_SIZE);
                button.setBackground(Color.WHITE);
                add(button);
                cells[i][j] = button;
            }
        }
    }
}

class Loop {
    static Scanner in = new Scanner(System.in);
    private static int rows;
    private static int columns;
    public static void main(String[] args) {
        ArrayList<ArrayList<Byte>> field = new ArrayList<ArrayList<Byte>>();
        try {
            field = readFile();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (IOException e) {
            System.out.println("IO exception");
        }
        rows = field.size();
        columns = field.get(0).size();
        new Field(field);
        gameLoop(field);
    }

    public static ArrayList<ArrayList<Byte>> readFile() throws FileNotFoundException, IOException {
        ArrayList<ArrayList<Byte>> field = new ArrayList<ArrayList<Byte>>();
        try (FileReader fileReader = new FileReader("src\\field.txt")) {
            Scanner scan = new Scanner(fileReader);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                ArrayList<Byte> row = new ArrayList<Byte>();
                for (int i = 0; i < line.length(); i++) {
                    row.add(Byte.parseByte(line.substring(i, i + 1)));
                }
                field.add(row);
            }
        }
        return field;
    }

    public static void gameLoop(ArrayList<ArrayList<Byte>> field) {
        while (true) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.println(i + " " + j + " " + countNeighbours(field, i, j));
            }
        }
        }
    }

    public static int countNeighbours(ArrayList<ArrayList<Byte>> field, int i, int j) {
        int count = 0;
        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                if (k >= 0 && k < rows && l >= 0 && l < columns) {
                    if (field.get(k).get(l) == 1) {
                        count++;
                    }
                }
            }
        }
        return field.get(i).get(j) == 0 ? count : count - 1;
    }
}