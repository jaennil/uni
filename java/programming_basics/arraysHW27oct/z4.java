/**
 * z4
 */
public class z4 {

    public static void main(String[] args) {
        int [][] matrix1 = new int[10][10];
        int [][] matrix2 = new int[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matrix1[i][j] = (int)(Math.random() * 1000);
                matrix2[i][j] = (int)(Math.random() * 1000);
            }
        }

        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2.length; j++) {
                System.out.print(matrix1[i][j] + matrix2[i][j] + " ");
            }
            System.out.println();
        }
    }
}