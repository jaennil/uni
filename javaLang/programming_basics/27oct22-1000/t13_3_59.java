import java.util.Scanner;
/**
 * 13_3_59
 */
public class t13_3_59 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a[] = new int[n];

        for (int i = 0; i < a.length; i++) {
            a[i] = (int)(Math.random() * 1000);
        }

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        double b[] = new double[n];

        for (int i = 0; i < b.length; i++) {
            double sum = 0;
            for (int j = 0; j < i + 1; j++) {
                sum += a[j];
            }

            double sra = sum/(i+1);

            b[i] = sra;
        }

        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
        
    }
}