import java.util.Scanner;

public class t_14_1_15
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
                System.out.print("Enter matrix degree: ");
                int degree = scanInt();
                
                while (degree % 2 == 0)
                {
                    println("Input number must be odd");
                    degree = scanInt();
                }
                matrix = generateSquareMatrix(degree, 0, 1000);

                break;

            case (2):
                matrix = inputMatrix();

                break;
        }
        
        return matrix;

    }

    public static int[][] generateMatrix(int rows, int columns, int min, int max)
    {
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = (int)(Math.random() * (max-min) + min);
            }
        }
        System.out.println("generated matrix:");
        printMatrix(matrix);

        return matrix;
    }
    
    public static int[][] generateSquareMatrix(int degree, int min, int max)
    {
        return generateMatrix(degree, degree, min, max);
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
        int longestValue = longestValue(matrix);
        System.out.println("-print array start-");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                for (int q = 0; q < longestValue - String.valueOf(matrix[i][j]).length() + 1; q++) {
                    print(" ");
                }
            }
            System.out.println();
        }
        System.out.println("-print array end-");
    }
    
    public static int longestValue(int [][] matrix)
    {
        int max = 0;
        int length;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                length = String.valueOf(matrix[i][j]).length();
                if (length > max)
                {
                    max = length;
                }
            }
        }
        return max;
    }
    
    public static void doTask(int [][] matrix)
    {
        System.out.println("after task:");
        
        int degree = matrix.length;
        
        for (int g = 0; g < degree/2; g++) {
            for (int i = 0+g; i < degree-g; i++) {
                print(matrix[g][i] + " ");
            }
            
            for (int i = 0+g; i < degree-2-g; i++) {
                print(matrix[i+1][degree-1-g] + " ");
            }
            
            for (int i = 0+g; i < degree-g; i++) {
                print(matrix[degree-1-g][degree-i-1] + " ");
            }
            
            for (int i = 0+g; i < degree-2-g; i++) {
                print(matrix[degree-i-2][g] + " ");
            }
            
        }
        print(matrix[degree/2][degree/2]);

    }
    
    public static void print(Object text)
    {
        System.out.print(text);
    }
    
    public static void println(Object text)
    {
        System.out.println(text);
    }
}

