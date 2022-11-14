public class z3 {
    public static void main(String[] args) {
        int [] arr = new int[10];

        for (int i = 0; i < 10; i++)
        {
            int v = (int)(Math.random() * 501 - 1000);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            if (i == arr.length - 1)
            {
                System.out.println();
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0)
            {
                System.out.print(-arr[i] + " ");
            }

            else
            {
                System.out.print(arr[i] + " ");
            }
        }
    }
}