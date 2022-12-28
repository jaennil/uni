import java.util.Scanner;
import java.util.InputMismatchException;

public class Z6{
  public static void main(String [] args){
    Scanner sc = new Scanner(System.in);

    int read_value;
    int p = 0;
    int res = 0;
    for (int cnt = 0; true; cnt++){

      try {
        read_value = sc.nextInt();

        if (read_value == p + 1){
          p++;
          if (p == 6){
            p = 0;
            res++;
          }
        }
        System.out.println(res);
      }

      catch (InputMismatchException e){
        System.out.println("wrong input");
        break;
      }
    }
  }
}
