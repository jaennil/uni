public class z2
{
    public static void main(String [] args) {
        int [] arr = new int[30];

        for (int i = 0; i < 30; i++)
        {
            arr[i] = (int)(Math.random() * 100 % 100 + 1);
        }

        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < 30; i++)
        {
            if (arr[i] > max)
            {
                max = arr[i];
            }

            if (arr[i] < min)
            {
                min = arr[i];
            }
        }

        for (int i = 0; i < 30; i++)
        {
            System.out.print(arr[i] + " ");
            if (i == 29)
            {
                System.out.println();
            }
        }

        System.out.println("max: " + max);
        System.out.print("min: " + min);

    }
}