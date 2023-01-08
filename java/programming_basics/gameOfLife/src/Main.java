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
    }

    public static ArrayList<ArrayList<Byte>> readFile() throws FileNotFoundException, IOException {
        ArrayList<ArrayList<Byte>> field = new ArrayList<ArrayList<Byte>>();
        try (FileReader fileReader = new FileReader("src\\field.txt")) {
            Scanner scan = new Scanner(fileReader);
            String line;
            while (scan.hasNextLine()) {
                line = scan.nextLine();
                ArrayList<Byte> row = new ArrayList<>();
                for (int i = 0; i < line.length(); i++) {
                    row.add(Byte.parseByte(line.substring(i, i + 1)));
                }
                field.add(row);
            }
        }
        return field;
    }
}