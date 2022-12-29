import java.util.Scanner;
/**
 * t13_2_33
 */
public class t13_2_33 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int [] arr = new int [n];

        int last = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 1000);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < arr.length; i++) {
            if (i == 0)
            {
                if (arr[i] > arr[i + 1])
                {
                    last = i;
                }
            }

            else if (i == arr.length - 1)
            {
                if (arr[i] > arr[i - 1])
                {
                    last = i;
                }
            }
            else if (arr[i] > arr[i-1] && arr[i] > arr[i+1])
            {
                last = i;
            }
        }
        System.out.println("index " + last);
    }
}