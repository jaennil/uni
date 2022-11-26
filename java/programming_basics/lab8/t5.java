import java.util.Scanner;

/**
 * t5
 */
public class t5 {
  static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.print("enter first string: ");
    String str1 = scan.nextLine();
    System.out.print("etner second string: ");
    String str2 = scan.nextLine();

    System.out.println("method result: " + concat(str1, str2));

    scan.close();
  }

  public static String concat(String str1, String str2) {
    char[] array = new char[str1.length() + str2.length()];
    for (int i = 0; i < str1.length(); i++) {
      array[i]=str1.charAt(i);
    }
    for (int i = str1.length(), cnt = 0; i < str1.length() + str2.length(); i++, cnt++) {
      array[i] = str2.charAt(cnt);
    }
    return String.valueOf(array);
  }
}
