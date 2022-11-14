import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("enter first number");
    int num1 = scanner.nextInt();
    System.out.println("enter second number");
    int num2 = scanner.nextInt();
    System.out.println("enter last number");
    int num3 = scanner.nextInt();

    int numbers[] = {num1, num2, num3};
    Arrays.sort(numbers);
    for (int i = 0; i < 3; i++) {
      System.out.print(numbers[i] + " ");
    }
  }
}
