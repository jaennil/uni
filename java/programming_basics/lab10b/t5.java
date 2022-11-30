import java.util.Scanner;

/**
 * t5
 */
public class t5 {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.print("enter number: ");
            int number = Integer.parseInt(in.nextLine());
            System.out.print("enter power: ");
            int power = Integer.parseInt(in.nextLine());
            System.out.println("iteratively: " + pow(number, power));
            System.out.println("iteratively with bitwise ops: " + bpow(number, power));
            System.out.println("recursively with bitwise ops: " + rpow(number, power));
            System.out.println();
        }
    }

    public static int pow(int number, int power) {
        int res = 1;
        while (power > 0) {
            if (power % 2 != 0) {
                res *= number;
            }
            power /= 2;
            number *= number;
        }
        return res;
    }

    public static int bpow(int number, int power) {
        int res = 1;
        while (power > 0) {
            if ((power & 1) != 0) {
                res *= number;
            }
            power >>= 1;
            number *= number;
        }
        return res;
    }

    public static int rpow(int number, int power) {
        if (power == 0)
            return 1;
        if ((power & 1) != 0)
            return number * rpow(number * number, power >> 1);
        return rpow(number * number, power >> 1);
    }
}