import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    //программа запрашивает 5 вещ чисел и выводит их среднее значение
    double n1 = scanner.nextDouble();
    double n2 = scanner.nextDouble();
    double n3 = scanner.nextDouble();
    double n4 = scanner.nextDouble();
    double n5 = scanner.nextDouble();
    System.out.println(test(n1, n2, n3, n4, n5));
  }
  public static double test(double n1, double n2, double n3, double n4,
                            double n5) {
    return (n1 + n2 + n3 + n4 + n5) / 5;
  }
}
