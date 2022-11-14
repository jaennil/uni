import java.util.Scanner;

public class t1
{
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        task();

        scan.close();
    }
    
    public static void task()
    {
        System.out.print("enter string: ");
        String input = scan.nextLine();
        System.out.print("enter char for finding: ");
        String chr = scan.nextLine();
        
        System.out.println(find(input, chr.charAt(0))); 
    }

    public static int find(String string, char chr)
    {
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == chr)
            {
                return i;
            }
        }
        return -1;
    }
}