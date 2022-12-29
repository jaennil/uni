import java.util.Scanner;
/**
 * t13_4_84
 */
public class t13_4_84 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 1000);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();


        int temp = arr[n-1];
        for (int i = arr.length-1; i > 0; i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = temp;

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        
    }
}