import java.util.InputMismatchException;
import java.util.Scanner;

public class t1 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int read_value;
    int zero_index = -1;
    int iterator = 0;
    while (true) {
      try {
        read_value = in.nextInt();
        if (zero_index == -1) {
          if (read_value == 0) {
            zero_index = iterator;
            System.out.println(zero_index + 1);
          } else {
            System.out.println(0);
          }
        } else {
          System.out.println(zero_index + 1);
        }

      } catch (InputMismatchException e) {
        System.out.println("wrong input");
        break;
      } finally {
      }
      iterator++;
    }
  }
}
