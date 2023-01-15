import java.util.Scanner;
import java.util.InputMismatchException;

public class t8 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int left;
        int middle;
        int right;
        int amount = 0;
        left = Integer.MIN_VALUE;
        middle = Integer.MIN_VALUE;

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
            if (left < middle) {
                amount++;
            }
            if (right > middle) {
                amount++;
            }
            left = middle;
            middle = right;
            System.out.println(amount);
        }
        console.close();
    }
}
