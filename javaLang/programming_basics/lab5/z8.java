import java.util.Scanner;
import java.util.InputMismatchException;

public class Z8
{
  public static void main(String [] args)
  {
    Scanner sc = new Scanner(System.in);
    int last = 0;
    int prev = 0;
    int cur;
    int result = 0;
    for (int cnt = 0; true; cnt++)
    {
      try
      {
        cur = sc.nextInt();

        if (cnt == 0)
        {
          last = cur;
          System.out.println(0);
          continue;
        }
        else if (cnt == 1)
        {
          prev = cur;
          System.out.println(0);
          continue;
        }
        else{
          if (prev > last && prev > cur)
          {
            result++;
          }
        }
        last = prev;
        prev = cur;
        System.out.println(result);
      }

      catch (InputMismatchException e)
      {
        System.out.println("wrong input");
        break;
      }
    }
  }
}
