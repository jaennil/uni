import java.util.Scanner;

public class t_14_1_12
{
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("enter 1 for generate random matrix or 2 for input matrix from console");
        
        int choice = scanInt();
        
        while (choice != 1 && choice != 2)
        {
            System.out.println("Enter 1 or 2");
            choice = scanInt();
        }
        
        int [][] matrix = handleChoice(choice);
        
        doTask(matrix);

        scan.close();
    }
    
    public static int[][] handleChoice(int choice)
    {
        int [][] matrix = new int[0][0];

        switch (choice)
        {
            case (1):
                System.out.print("Enter amount of rows: ");
                int rows = scanInt();

                System.out.print("Enter amount of columns: ");
                int columns = scanInt();

                matrix = generate_matrix(rows, columns);

                break;

            case (2):
                matrix = inputMatrix();

                break;
        }
        
        return matrix;

    }
    public static int[][] generate_matrix(int rows, int columns)
    {
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = (int)(Math.random() * 1000 - 500);
            }
        }
        System.out.println("generated matrix:");
        printMatrix(matrix);

        return matrix;
    }
    
    public static int[][] inputMatrix()
    {
        System.out.print("Enter amount of rows: ");
        int rows = scanInt();

        System.out.print("Enter amount of columns: ");
        int columns = scanInt();
        
        int [][] matrix = new int[rows][columns];
        
        String row;
        String [] splited_row;
        for (int i = 0; i < rows; i++) {
            row = scan.nextLine();
            splited_row = row.split(" ");

            for (int j = 0; j < splited_row.length; j++) {
                matrix[i][j] = Integer.parseInt(splited_row[j]);
            }
        }
        return matrix;
    }
    
    public static int scanInt()
    {
        int read_value;
        try
        {
            read_value = Integer.parseInt(scan.nextLine());
        }
        catch (NumberFormatException e)
        {
            System.out.println("Input value must be integer");
            return scanInt();
        }
        return read_value;
    }

    public static void printMatrix(int [][] matrix)
    {
        System.out.println("-print array start-");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-print array end-");
    }
    
    public static void doTask(int [][] matrix)
    {
        System.out.println("after task:");
        
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i % 2 == 0)
                {
                    System.out.print(matrix[j][i] + " ");
                }
                else
                {
                    System.out.print(matrix[matrix.length - j - 1][i] + " ");
                }
            }
            System.out.println();
        }
    }
}
