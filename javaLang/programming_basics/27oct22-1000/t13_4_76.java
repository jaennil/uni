import java.util.Scanner;
public class t13_4_76 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n];
        int arr2[] = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 1000);
        }

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arr[i];
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
                    arr2[i] = 0;
                }
            }
            else if (i == n - 1)
            {
                if (arr[i] > arr[i - 1])
                {
                    arr2[i] = 0;
                }
            }
            else
            {
                if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1])
                {
                    arr2[i] = 0;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        
    }
}
