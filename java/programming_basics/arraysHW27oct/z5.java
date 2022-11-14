/**
 * z5
 */
public class z5 {

    public static void main(String[] args) {
        int [][] matrix = new int[10][10];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = (int)(Math.random() * 1000);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            int minr = matrix[i][0];
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] < minr)
                {
                    minr = matrix[i][j];
                }
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("min " + minr);
            System.out.println();
        }

        for (int i = 0; i < 10; i++) {
            System.out.print("max ");
        }
        System.out.println();

        for (int i = 0; i < 10; i++)
        {
            int maxr = matrix[0][i];
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] > maxr)
                {
                    maxr = matrix[j][i];
                }
            }
            System.out.print(maxr + " ");
        }
    }
}