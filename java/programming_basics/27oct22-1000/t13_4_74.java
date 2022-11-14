import java.util.Scanner;
/**
 * t13_3_74
 */
public class t13_4_74 {

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

        int min = arr[0];
        int minindex = 0;
        int max = arr[0];
        int maxindex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
            {
                maxindex = i;
                max = arr[i];
            }

            if (arr[i] < min)
            {
                minindex = i;
                min = arr[i];
            }
        }
        
        int mx = 0;
        int mn = 0;
        if (maxindex > minindex)
        {
            mx = maxindex;
            mn = minindex;
        }

        else if (minindex >= maxindex)
        {
            mx = minindex;
            mn = maxindex;
        }

        for (int i = 0; i < arr.length; i++) {
            if ((i > mn) && (i < mx))
            {
                System.out.print(0 + " ");
            }

            else
            {
                System.out.print(arr[i] + " ");
            }
        }
    }
}