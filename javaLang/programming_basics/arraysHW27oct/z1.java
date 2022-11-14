public class z1
{
    public static void main(String [] args) {
        int [] arr = new int[10];

        for (int i = 0; i < 10; i++)
        {
            arr[i] = (int) (Math.random() * 21 + 10);
        }
        
        for (int i = 0; i < 10; i++)
        {
            System.out.print(arr[i] + " ");
            if (i == 9)
            {
                System.out.println();
            }
        }

        for (int i = 9; i > -1; i--)
        {
            System.out.print(arr[i] + " ");
        }
    }
}