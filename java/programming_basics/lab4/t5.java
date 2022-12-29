import java.util.Scanner;
import java.util.InputMismatchException;

public class t5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int current;
        int previous = 0;
        int amount = 0;
        while (true) {
            try {
                current = scan.nextInt();
                while (current != 0 && current != 1) {
                    System.out.println("wrong input. You can only use 1 or 0. Try again");
                    try {
                        current = scan.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("wrong input");
                        scan.close();
                        return;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("wrong input");
                break;
            }

            if (current == 0) {
                if (previous == 1) {
                    amount++;
                }
            }
            System.out.println(amount);
            previous = current;
        }
        scan.close();
    }
}
