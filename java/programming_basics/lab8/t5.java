import java.util.Scanner;

/**
 * t5
 */
public class t5 {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("enter first string: ");
        String str1 = scan.nextLine();
        System.out.print("etner second string: ");
        String str2 = scan.nextLine();

        System.out.print("method result: " + concat(str1, str2));

        scan.close();
    }

    public static String concat(String str1, String str2) {
        return str1 + str2;
    }
}