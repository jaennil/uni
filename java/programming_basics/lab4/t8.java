import java.util.Scanner;
import java.util.InputMismatchException;

public class t8 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int left;
        int middle;
        int right;
        int amount = 0;
        try {
            left = console.nextInt();
            System.out.println(1);
            middle = console.nextInt();
            System.out.println(1);
        } catch (InputMismatchException e) {
            System.out.println("Error: " + e);
            console.close();
            return;
        }

        while (true) {
            try {
                right = console.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: " + e);
                break;
            }
            if (left < middle && middle > right) {
                amount++;
            }
            left = middle;
            middle = right;
            System.out.println(amount);
        }
        console.close();
    }
}
