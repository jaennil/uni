import java.util.Scanner;
/**
 * t3
 */
public class t3 {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("enter string 1: ");
        String str1 = scan.nextLine();
        System.out.print("enter string 2: ");
        String str2 = scan.nextLine();
        System.out.print("enter amount of numbers: ");
        int amount = Integer.parseInt(scan.nextLine());
        
        scan.close();
    }
    
    public static void matches(String str1, String str2, int amount) {
    }
}