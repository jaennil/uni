import java.util.Scanner;

public class arrays{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String [] a = new String[10];
        for (int i = 0; i < 10; i++)
        {
            a[i] = sc.nextLine();
        }
        sc.close();

        for (int i = 0; i < 10; i++)
        {
            System.out.print(a[i] + ' ');
        }
    }
}