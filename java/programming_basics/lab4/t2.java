import java.util.Scanner;
import java.util.InputMismatchException;

public class t2 {
    public static void main(String[] args) {
        int previous = 0;
        Scanner scan = new Scanner(System.in);
        try {
            previous = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("wrong input");
            scan.close();
            return;
        }
        int current;
        int cnt = 1;
        while (true) {
            System.out.println(cnt);
            // read from console
            try {
                current = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("wrong input");
                break;
            }

            if (current > previous) {
                cnt++;
            }
            previous = current;
        }
        scan.close();
    }
}
