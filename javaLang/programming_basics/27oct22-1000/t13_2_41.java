import java.util.Scanner;
/**
 * t13_2_41
 */
public class t13_2_41 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int [] arr = new int [n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 1000);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        int max2 = arr[0] + arr[1];

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] + arr[i + 1] > max2)
            {
                max2 = arr[i] + arr[i + 1];
            }
        }

        System.out.println(max2);

    }
}