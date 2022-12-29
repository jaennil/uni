import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
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
        int rows = field.size();
        int columns = field.get(0).size();
//        while (true) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.println(i + " " + j + " " + countNeighbours(field, i, j));
                }
            }
//        }
    }

    public static int countNeighbours(ArrayList<ArrayList<Byte>> field, int i, int j) {
        int rows = field.size();
        int columns = field.get(0).size();
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