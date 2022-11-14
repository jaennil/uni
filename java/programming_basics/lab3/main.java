public class Main {
  public static void main(String[] args) {
    //программа вычисляет колво четных чисел кратных 3 в диапазоне от 10 до 60
    System.out.println(test());
  }
  public static int test() {
    int result = 0;
    for (int i = 20; i <= 60; i++) {
      if (i % 3 == 0 && i % 2 == 0) {
        result++;
      }
    }
    return result;
  }
}
