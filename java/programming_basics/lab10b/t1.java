import java.util.Scanner;

/**
 * t1
 */
public class t1 {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n1 = Integer.parseInt(in.nextLine());
        int n2 = Integer.parseInt(in.nextLine());
        System.out.println(a(n1, n2));
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

    public static int b(int n1, int n2) {
        return -1;
    }

}