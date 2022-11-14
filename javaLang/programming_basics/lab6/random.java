import java.util.Scanner;

public class random {
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int [] array = new int[length];

        for (int i = 0; i < length; i++)
            array[i] = (int)(Math.random() * 10);

        for (int i = 0; i < length; i++)
            System.out.println(array[i]);

        int sum = 0;
        for (int i = 0; i < length; i++)
           sum += array[i]; 
        System.out.println((double)sum/length);

        sc.close();
    }
}
