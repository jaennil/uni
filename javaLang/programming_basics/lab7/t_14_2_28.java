import java.util.Scanner;

public class t_14_2_28
{
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("enter 1 for generate random matrix or 2 for input matrix from console");
        
        int choice = scanInt();
        
        while (choice != 1 && choice != 2)
        {
            System.out.print("Enter 1 or 2: ");
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
                print("Enter amount of rows: ");
                int rows = scanInt();

                print("Enter amount of columns: ");
                int columns = scanInt();
                
                matrix = generateMatrix(rows, columns, -500, 500);

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
        print(matrix);

        return matrix;
    }
    
    public static int[][] generateMatrix(int degree, int min, int max)
    {
        return generateMatrix(degree, degree, min, max);
    }

    public static int[][] inputMatrix()
    {
        System.out.print("Enter amount of rows: ");
        int rows = scanInt();

        System.out.print("Enter amount of columns: ");
        int columns = scanInt();
        
        println("Available input for 3 rows and 4 columns: ");
        println("1 2 3 4");
        println("5 6 7 8");
        println("4 3 2 1");

        
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

    public static void print(int [][] matrix)
    {
        int longestValue = longestValue(matrix);
        println("");
        System.out.println("-print matrix start-");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                for (int q = 0; q < longestValue - String.valueOf(matrix[i][j]).length() + 1; q++) {
                    print(" ");
                }
            }
            System.out.println();
        }
        System.out.println("-print matrix end-");
        println("");
    }
    
    public static void print(int [] array)
    {
        println("");
        System.out.println("-print array start-");
        for (int i = 0; i < array.length; i++) {
            print(array[i] + " ");
        }
        println();
        System.out.println("-print array end-");
        println("");
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
    
    public static int longestValue(int [] array)
    {
        int max = 0;
        int length;
        for (int i = 0; i < array.length; i++) {
            length = String.valueOf(array[i]).length();
            if (length > max)
            {
                max = length;
            }
        }
        return max;
    }
    
    public static void doTask(int [][] matrix)
    {
        System.out.println("after task:");
        
        int [] matrixMetrics = getMetrics(matrix);
        int rows = matrixMetrics[0];
        int columns = matrixMetrics[1];
        int [] maxs = new int[columns];
        
        for (int i = 0; i < columns; i++) {
            int [] column = new int[rows];
            for (int j = 0; j < rows; j++) {
                column[j] = matrix[j][i];
            }
            maxs[i] = max(column);
        }

        print(min(maxs));

    }
    
    public static int max(int [] array)
    {
        int max = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max)
            {
                max = array[i];
            }
        }
        
        return max;
    }
    
    public static int min(int [] array)
    {
        int min = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min)
            {
                min = array[i];
            }
        }
        
        return min;
    }
    
    public static int[] getMetrics(int [][] matrix)
    {
        // rows, columns
        int [] ret = {matrix.length, matrix[0].length};
        return ret; 
    }
    
    public static void print(Object text)
    {
        System.out.print(text);
    }
    
    public static void println(Object text)
    {
        System.out.println(text);
    }
    
    public static void println()
    {
        System.out.println();
    }
}



