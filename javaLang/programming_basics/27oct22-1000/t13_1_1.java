import java.util.Scanner;
public class t13_1_1
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int [] arr = new int [n];
        for (int i = 0, j = 1; i < 10; i++, j += 2)
        {
            arr[i] = j;
        }

        for (int i = 0; i < 10; i++)
        {
            System.out.print(arr[i] + " ");
        }

    }
}