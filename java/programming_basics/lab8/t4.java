import java.util.Scanner;

/**
 * t4
 */
public class t4 {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("enter first string: ");
        String str1 = scan.nextLine();
        System.out.print("enter second string: ");
        String str2 = scan.nextLine();

        System.out.println("method result: " + compare(str1, str2));
    }

    public static short compare(String str1, String str2) {
        String[] alphabets = new String[] { "abcdefghijklmnopqrstuvwxyz", "ABCDEFGHIJKLMNOPQRSTUVWXYZ" };

        int str1len = str1.length();
        int str2len = str2.length();

        int mn;
        if (str1len > str2len) {
            mn = str2len;
        } else {
            mn = str1len;
        }

        int char1index = 0;
        int char2index = 0;
        for (int i = 0; i < mn; i++) {
            for (int j = 0; j < 4; j++) {
                char1index = find(alphabets[j], str1.charAt(i));
                if (char1index != -1) {
                    break;
                }
            }
            for (int j = 0; j < 4; j++) {
                char2index = find(alphabets[j], str2.charAt(i));
                if (char2index != -1) {
                    break;
                }
            }

            if (char1index == -1 || char2index == -1) {
                throw new Error("Can't find symbol in alphabets");
            } else if (char1index > char2index) {
                return 1;
            } else if (char1index < char2index) {
                return -1;
            } else {
                continue;
            }
        }

        return 0;
    }

    public static int find(String string, char chr) {
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == chr) {
                return i;
            }
        }
        return -1;
    }

}