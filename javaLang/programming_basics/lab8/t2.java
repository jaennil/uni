import java.util.Scanner;

public class t2
{
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("enter string: ");
        String string = scan.nextLine();
        System.out.print("enter substring to find in string: ");
        String substring = scan.nextLine();

        System.out.println("index of substring is: " + find(string, substring));
        
        scan.close();
    }
    
    public static int find(String string, String substring)
    {
        for (int i = 0; i < string.length()-substring.length()+1; i++) {
            if (string.charAt(i) == substring.charAt(0))
            {
                if (substringEqual(string, substring, i))
                {
                    return i;
                }
            }
        }
        
        return -1;
    }
    
    public static boolean substringEqual(String string, String substring, int index)
    {
        int mn;
        int sl = string.length() - index;
        int ssl = substring.length();

        if (sl > ssl)
        {
            mn = ssl;
        }
        else
        {
            mn = sl;
        }
        
        for (int i = 0; i < mn; i++) {
            if (string.charAt(index + i) != substring.charAt(i))
            {
                return false;
            }
        }
        
        return true;
    }
    
}