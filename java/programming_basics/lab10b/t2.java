import java.util.Scanner;

public class t2 {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.print("enter number: ");
            int num = Integer.parseInt(in.nextLine());
            System.out.print("enter power: ");
            int power = Integer.parseInt(in.nextLine());
            System.out.println("result: " + pow(num, power));
        }
    }

    public static int pow(int number, int power) {
        return _pow(number, number, power);
    }

    public static int _pow(int snumber, int number, int power) {
        if (power == 1)
            return number;
        return _pow(snumber, snumber * number, power - 1);
    }
}
