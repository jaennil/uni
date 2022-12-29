import java.util.Scanner;
import java.util.InputMismatchException;

public class t6 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int input;
        int cnt = 0;
        int result = 0;

        while (true) {
            try {
                input = console.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("wrong input");
                break;
            }
            if (input == cnt + 1) {
                cnt++;
                if (cnt == 6) {
                    cnt = 0;
                    result++;
                }
            }
            System.out.println(result);
        }
        console.close();
    }
}
