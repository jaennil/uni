import java.util.Scanner;
import java.util.InputMismatchException;

public class Z5{
  public static void main(String [] args){
    Scanner sc = new Scanner(System.in);
    int read_value;
    int temp = 0;
    int groups = 0;
    boolean ones = false;
    boolean have0 = false;
    for (int cnt = 0; true; cnt++){
      try {
        read_value = sc.nextInt();

        if (read_value == 0){
          if (have0){
            if (ones){
              ones = false;
              groups++;
            }
          }

          else{
            have0 = true;
          }
        }
        else if (read_value == 1){
          if (have0){
            ones = true;
          }
        }
        System.out.println(groups);
      }

      catch (InputMismatchException e){
        System.out.println("wrong input");
        break;
      }
    }
  }
}
