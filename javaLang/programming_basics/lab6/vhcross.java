import java.util.Scanner;

public class vhcross {
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter size");
        int size = sc.nextInt();

        String [][] arr = new String[size][size];
        
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                if (size % 2 == 0){
                    if (i == size / 2 - 1 || i == size / 2 || j == size / 2 || j == size / 2 - 1)
                    {
                        arr[i][j] = "#";
                    }
                    else
                    {
                        arr[i][j] = " ";
                    }
                }
                else
                {
                    if (i == size / 2 || j == size / 2)
                    {
                        arr[i][j] = "#";
                    }
                    else
                    {
                        arr[i][j] = " ";
                    }
                    
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
