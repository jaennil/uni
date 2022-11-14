import java.util.Scanner;
/**
 * t13_1_6
 */
public class t13_1_6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        int [] arr = new int [n];

        arr[0] = a;
        arr[1] = b;

        int sum = a + b;
        for (int i = 2; i < n; i++)
        {
            arr[i] = sum;
            sum += arr[i];
        }


        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        
    }
}