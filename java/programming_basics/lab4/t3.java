import java.util.Scanner;
import java.util.InputMismatchException;

public class t3 {
	public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int max = 0;
        try {
            max = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("wrong input");
            scan.close();
            return;
        }
        int max2 = Integer.MIN_VALUE;
        int input;

        while (true) {
            // print stuff
            if (max2 == Integer.MIN_VALUE) {
                System.out.println("No");
            } else {
                System.out.println(max2);
            }
            // read from console
            try {
                input = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("wrong input");
                break;
            }
            // logic
            if (input > max) {
                max2 = max;
                max = input;
            } else if (input > max2) {
                max2 = input;
            }
        }
        scan.close();
	}
}
