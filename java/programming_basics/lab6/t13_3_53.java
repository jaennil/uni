import java.util.Scanner;
/**
 * t13_3_53
 */
public class t13_3_53 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int a[] = new int[n];
        int b[] = new int[n];
        
        for (int i = 0; i < b.length; i++) {
            a[i] = (int)(Math.random() * 1000);
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = (int)(Math.random() * 1000);
        }

        System.out.println("A");
        for (int i = 0; i < b.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println("B");

        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();

        int c[] = new int[n];

        for (int i = 0; i < c.length; i++) {
            if (a[i] > b[i])
            {
                c[i] = a[i];
            }

            else
            {
                c[i] = b[i];
            }
        }

        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + " ");
        }
    }
}