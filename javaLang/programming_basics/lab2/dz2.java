import java.util.Scanner;
public class Dz2 {
  public static void main(String[] args) {
    System.out.println(calculate_new_pos("вперед", 10, 10));
  }
  public static int calculate_new_pos(String command, int amount,
                                      int current_pos) {
    System.out.println(command);
    System.out.println(amount);
    System.out.println(current_pos);
    if (command == "вперед") {
      System.out.println("f");
      if (current_pos + amount > 99) {
        return 99;
      }
      return current_pos + amount;
    }
    if (command == "назад") {
      System.out.println("b");
      if (current_pos - amount < 0) {
        return 0;
      }
      return current_pos - amount;
    }
    return 0;
  }
}
