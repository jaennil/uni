import java.util.Scanner;
import java.util.InputMismatchException;

public class t7 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int previous;
        try {
            previous = console.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("wrong input");
            console.close();
            return;
        }
        int input;
        int cnt12 = 0;
        int max = 0;
        while (true) {
            System.out.println(max);

            try {
                input = console.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("wrong input");
                break;
            }
            if (input == 2 && previous == 1) {
                cnt12++;
                if (cnt12 >= 3) {
                    max++;
                }
            } else if (input != 1 || previous != 2) {
                cnt12 = 0;
            }
            previous = input;
        }
        console.close();
    }
}
