import java.util.Scanner;
/**
 * t13_2_26
 */
public class t13_2_26 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];

        boolean flag = true;
        boolean even = false;
        int last = -1;
        
        for (int i = 0; i < arr.length; i++) {
            if (i == 0)
            {
                if (arr[i] % 2 == 0)
                {
                    even = true;
                }
            }

            else
            {
                if (arr[i] % 2 == 0 && even)
                {
                    last = i;
                    flag = false;
                    break;
                }
                else if (arr[i] % 2 != 0 && !even)
                {
                    last = i;
                    flag = false;
                    break;
                }
            }
        }

        if (flag)
        {
            System.out.println(0);
        }

        else
        {
            System.out.println(last);
        }
    }
}