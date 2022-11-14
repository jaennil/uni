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
        
        System.out.println("method result " + matches(str1, str2, amount));
        scan.close();
    }
    
    public static boolean matches(String str1, String str2, int amount)
    {
        int str1len = str1.length();
        int str2len = str2.length();

        if (amount > str1len || amount > str2len)
        {
            return false;
        }
        
        for (int i = 0; i < amount; i++) {
            if (str1.charAt(i) != str2.charAt(i))
            {
                return false;
            }
        }
        
        return true;
    }
}