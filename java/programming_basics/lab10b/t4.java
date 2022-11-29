import java.util.Scanner;

/**
 * t3
 */
public class t4 {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            int num = Integer.parseInt(in.nextLine());
            weirdprint(num);
        }
    }

    public static int weirdprint(int number) {
        int end = (number % 10);
        System.out.println("end " + end);
        if (number < 10)
            return number;
        return weirdprint((number - (number % 10)) / 10);
    }
}