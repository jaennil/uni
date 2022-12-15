import java.util.Scanner;

public class test {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        byte input = 0;
        try {
            input = Byte.parseByte(in.nextLine());
        }
        catch (NumberFormatException e) {
            System.out.println("Bad String");
        }
        System.out.println(input);

    }
}
