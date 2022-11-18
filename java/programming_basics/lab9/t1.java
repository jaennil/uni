import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

/**
 * t1
 */
public class t1 {
    public static void main(String[] args) {
        try (FileWriter fw = new FileWriter("output.txt")) {

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        try (FileReader fr = new FileReader("input.txt")) {
            Scanner in = new Scanner(fr);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

    }
}