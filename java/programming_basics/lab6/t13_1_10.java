import java.util.Scanner;
/**
 * t13_1_10
 */
public class t13_1_10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int [] arr = new int [n];

        for (int i = 0; i < n; i++)
        {
            arr[i] = (int)(Math.random() * 1000);
        }

        for (int i = 0; i < n; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0)
            {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();

        for (int i = 9; i > -1; i--) {
            if (arr[i] % 2 != 0)
            {
                System.out.print(arr[i] + " ");
            }
        }
    }
}