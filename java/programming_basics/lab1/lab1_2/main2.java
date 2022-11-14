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
    int max1 = 0;
    int max2 = 0;
    int max3 = 0;

    if (num1 > num2 && num1 > num3) {
      max1 = num1;
      if (num2 > num3) {
        max2 = num2;
        max3 = num3;
      } else {
        max2 = num3;
        max3 = num2;
      }

    } else if (num2 > num1 && num2 > num3) {
      max1 = num2;
      if (num1 > num3) {
        max2 = num1;
        max3 = num3;
      } else {
        max2 = num3;
        max3 = num1;
      }
    }

    else {
      max1 = num3;
      if (num1 > num2) {
        max2 = num1;
        max3 = num2;
      } else {
        max2 = num2;
        max3 = num1;
      }
    }
    System.out.println(max3);
    System.out.println(max2);
    System.out.println(max1);
  }
}
