//программа выводит цифры
//надо у пользователя зарпосить целое число и вывести цифры которые это число
//оссотоит
import java.util.Scanner;
public class Main3 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String num = scanner.next();
    for (int i = 0; i < num.length(); i++) {
      System.out.println(num.charAt(i));
    }
  }
}
