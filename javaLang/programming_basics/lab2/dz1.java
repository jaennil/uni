public class Dz1 {
  public static void main(String[] args) { System.out.println(test(26)); }

  public static String test(int temp) {
    if (temp < 10) {
      return "холодно";
    } else if (temp >= 10 && temp <= 25) {
      return "тепло";
    } else {
      return "жарко";
    }
  }
}
