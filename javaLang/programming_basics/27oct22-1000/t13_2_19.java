/**
 * t13_2_19
 */
public class t13_2_19 {

    public static void main(String[] args) {
        
        int [] arr = new int[10];

        for (int i = 0; i < 10; i++)
        {
            arr[i] = (int) (Math.random() * 1000);
        }

        int last = 0;

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[0] && arr[i] < arr[9])
            {
                last = arr[i];
            }
        }

        System.out.println(last);
    }
}