import java.util.Scanner;

public class Dz3 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("enter salary to calculate tax");
    int salary = scanner.nextInt();
    System.out.println("calculated tax: " + calculate_tax(salary));
  }
  public static int calculate_tax(int salary) {
    int tax;
    if (salary < 35000) {
      tax = salary * 15 / 100;
    } else if (salary >= 35000 && salary <= 100000) {
      tax = salary * 25 / 100;
    } else {
      tax = salary * 35 / 100;
    }
    if (salary > 50000) {
      tax += salary * 5 / 100;
    }
    return tax;
  }
}
