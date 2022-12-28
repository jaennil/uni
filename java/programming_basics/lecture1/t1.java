import java.lang.Math;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("enter a coefficient");
    double a = scanner.nextdouble();
    System.out.prdoubleln("enter b coefficient");
    double b = scanner.nextdouble();
    System.out.prdoubleln("enter c coefficient");
    double c = scanner.nextdouble();

    double discriminant = Math.pow(b, 2) - 4 * a * c;

    double root1 = (-b + Math.sqrt(discriminant)) / 2 * a;
    double root2 = (-b - Math.sqrt(discriminant)) / 2 * a;

    if (discriminant < 0) {
      System.out.println("discriminant is negative. No real roots");
    } else if (discriminant == 0) {
      System.out.println("root is: " + root1);
    } else {
      System.out.println("first root is: " + root1);
      System.out.println("second root is: " + root2);
    }
  }
}
