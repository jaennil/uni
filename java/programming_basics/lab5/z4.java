import java.util.Scanner;
import java.util.InputMismatchException;

public class Z4{
  public static void main(String [] args){
    Scanner sc = new Scanner(System.in);

    int read_value;
    int last_value;
    for (int cnt = 0; true; cnt++){
      try {
        read_value = sc.nextInt();
      }

      catch (InputMismatchException e){
        System.out.println("wrong input");
        break;
      }

      if (cnt == 0){
        last_value = read_value;
      }





      
    }
  }
}
