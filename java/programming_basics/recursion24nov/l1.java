public class l1 {
  public static void main(String[] args) {
    System.out.println(fib(1));
    System.out.println(fib(2));
    System.out.println(fib(3));
    System.out.println(fib(4));
    System.out.println(fib(5));
    System.out.println(fib(6));
    System.out.println(fib(7));
    System.out.println(fib(8));
  }

  public static int factorial(int number) {
    int start = 1;
    for (int i = 2; i < number + 1; i++) {
      start *= i;
    }

    return start;
  }

  public static int rfactorial(int number) {
    return number == 0 ? 1 : number * rfactorial(number - 1);
  }

  public static int fib(int number) {
    if (number == 0)
      return 0;
    if (number == 1)
      return 1;
    return fib(number - 2) + fib(number - 1);
  }

}
