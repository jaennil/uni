public class test
{
    public static void main(String[] args) {
        int [][] arr = new int[3][3];

        int [][] newArr = new int[3][3];

        newArr[0] = arr[0];

        print(newArr);
        print(arr);
        
        arr[0][0] = 1;

        print(arr);
        print(newArr);
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