import java.util.Scanner;
import java.util.InputMismatchException;

public class Z7
{
  public static void main(String [] args)
  {
     Scanner sc = new Scanner(System.in);

     int read_value;
     // 0 for unset
     int last = 0;
     int length = 0;
     int result = 0;
     for (int cnt = 0; true; cnt++)
     {
       
       try 
       {
         read_value = sc.nextInt();

         if (read_value == 1)
         {
           //start
           if (last == 0 || last == 2)
           {
             length++;
           }
         }
         else if (read_value == 2)
         {
           if (last == 1)
           {
             length++;
             if (length == 6)
             {
               result++;
               length = 0;
             }
           }
         }
         last = read_value;
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
