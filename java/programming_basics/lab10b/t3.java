import java.util.Scanner;

/**
 * t3
 */
public class t3 {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.print("enter number: ");
            int num = Integer.parseInt(in.nextLine());
            System.out.println("result: " + stdigit(num));
        }
    }

    public static int stdigit(int number) {
        if (number < 10)
            return number;
        return stdigit((number - (number % 10)) / 10);
    }
}