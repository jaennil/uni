import java.util.Scanner;

public class t2 {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("enter string: ");
        String string = scan.nextLine();
        System.out.print("enter substring to find in string: ");
        String substring = scan.nextLine();

        System.out.println("index of substring is: " + find(string, substring));

        scan.close();
    }

    public static int find(String string, String substring) {
        int cnt = 0;
        int index = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == substring.charAt(cnt)) {
                if (cnt == 0) {
                    index = i;
                }
                cnt++;
            } else {
                cnt = 0;
            }
            if (cnt == substring.length()) {
                return index;
            }
        }
        return -1;
    }
}