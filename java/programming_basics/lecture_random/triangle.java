import java.util.Scanner;

public class triangle {
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter size");
        int size = sc.nextInt();

        String [][] arr = new String[size][size];
        
        for (int i = 0; i < size; i++)
        {
            for (int q = 0; q < size; q++)
                arr[i][q] = " ";
            for (int j = 0; j < size - i*2; j++)
            {
                arr[i][j+i] = "#";
            }

            if (i > size / 2){
                for (int w = 0; w < i; w++)
                {
                    arr[i][w + i] = "#";
                }
            }
        }

        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
