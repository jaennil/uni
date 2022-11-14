import java.util.Scanner;
/**
 * t13_3_63
 */
public class t13_4_70 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr [] = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 1000);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        int arr3[] = new int[n/2];

        for (int i = 0; i < n/2; i++) {
            arr3[i] = arr[i];
            arr[i] = arr[i + n/2];
        }

        for (int i = 0; i < n/2; i++) {
            arr[i + n/2] = arr3[i];
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }




    }
}