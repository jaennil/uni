import java.util.regex.Pattern;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * t3
 */
public class t3 {

    public static void main(String[] args) {
        try (FileReader fr = new FileReader("input.txt")) {
            try (Scanner in = new Scanner(fr)) {
                String line;
                while (in.hasNextLine()) {
                    line = in.nextLine();
                    if (line.length() == 0) {
                        continue;
                    }
                    String[] splited = line.split(":");
                    if (splited.length != 3) {
                        continue;
                    }
                    String fio = formatFio(splited[0]);
                    String date = formatDate(splited[1]);
                    String number = formatNumber(splited[2]);
                    if (!goodDateData(date)) {
                        System.out.println(date);
                    }
                    if (!goodFioData(fio)) {
                        System.out.println(fio);
                    }
                    if (!goodNumberData(number)) {
                        System.out.println(number);
                    }
                }
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public static boolean includes(char[] array, char chr) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == chr) {
                return true;
            }
        }
        return false;
    }

    public static String formatFio(String fio) {
        String[] splited = fio.split(" ");
        String result = "";
        for (int i = 0, cnt = 0; i < splited.length; i++) {
            if (splited[i] != "") {
                result += splited[i];
                if (cnt != 2) {
                    result += " ";
                }
                cnt++;
            }
        }
        return result;
    }

    public static String formatDate(String date) {
        String result = "";
        for (int i = 0; i < date.length(); i++) {
            char chr = date.charAt(i);
            if (Character.isDigit(chr) || chr == '.') {
                result += chr;
            }
        }
        return result;
    }

    public static String formatNumber(String number) {
        String result = "";
        char[] numberMarks = { '+', '(', ')', '-' };
        for (int i = 0; i < number.length(); i++) {
            char chr = number.charAt(i);
            if (Character.isDigit(chr) || includes(numberMarks, chr)) {
                result += chr;
            }
        }
        return result;
    }

    public static boolean goodDateData(String date) {
        return Pattern.matches("(\\d{2}\\.){2}\\d{4}", date);
    }

    public static boolean goodNumberData(String number) {
        return Pattern.matches("\\+\\d\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}", number);
    }

    public static boolean goodFioData(String fio) {
        return Pattern.matches("([а-яА-Я]+\\s){2}[а-яА-Я]+", fio);
    }
}
