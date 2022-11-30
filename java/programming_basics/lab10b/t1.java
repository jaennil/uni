import java.util.Scanner;

/**
 * t1
 */
public class t1 {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("enter first number: ");
        int n1 = Integer.parseInt(in.nextLine());
        System.out.print("enter second number: ");
        int n2 = Integer.parseInt(in.nextLine());
        System.out.println("GCD: " + gcd(n1, n2));
        System.out.println("recursive GCD: " + rgcd(n1, n2));
    }

    public static int gcd(int n1, int n2) {
        // greatest common divisor(НОД)
        int mn = n1 < n2 ? n1 : n2;
        for (int i = mn; i > 0; i--) {
            if (n1 % i == 0 && n2 % i == 0) {
                return i;
            }
        }
        return -1;
    }

    public static int rgcd(int n1, int n2) {
        // recursive realisation of greatest common divisor
        // todo

        return -1;
    }

}