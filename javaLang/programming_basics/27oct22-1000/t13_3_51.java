import java.util.Scanner;
/**
 * t13_3_51
 */
public class t13_3_51 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr2[] = new int[n];
        int arr1[] = new int[n];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (int)(Math.random() * 1000);
            arr2[i] = (int)(Math.random() * 1000);
        }

        System.out.println("A:");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        System.out.println("B:");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();

        int temp = 0;
        for (int i = 0; i < arr1.length; i++) {
            temp = arr1[i];
            arr1[i] = arr2[i];
            arr2[i] = temp;
        }


        System.out.println("A:");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        System.out.println("B:");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }

    }
}