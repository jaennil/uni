import java.util.Scanner;
public class u1 {
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter columns");
        int rows = sc.nextInt();
        System.out.println("enter rows");
        int columns = sc.nextInt();
        
        int [][] two_dimensional_array = new int[rows][columns];
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                two_dimensional_array[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                System.out.print(two_dimensional_array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
