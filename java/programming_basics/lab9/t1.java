import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

/**
 * t1
 */
public class t1 {
    public static void main(String[] args) {
        try (
                FileWriter fw = new FileWriter("output.txt")) {
            try (FileReader fr = new FileReader("input.txt")) {
                Scanner in = new Scanner(fr);

                String line;
                for (int lineNumber = 1; in.hasNextLine(); lineNumber++) {
                    line = in.nextLine();
                    if (line.length() == 0) {
                        System.out.println("found empty line " + lineNumber + "\n");
                        continue;
                    }
                    String[] splited = line.split(":");
                    if (splited.length != 3) {
                        System.out.println("wrong formated line: " + lineNumber + "\n");
                        continue;
                    }
                    String fio = formatFio(splited[0]);
                    String date = formatDate(splited[1]);
                    String number = formatNumber(splited[2]);

                    fw.write(fio + ":");
                    fw.write(date + ":");
                    fw.write(number + "\n");
                    System.out.println(fio);
                    System.out.println(date);
                    System.out.println(number);

                    System.out.print("\n");
                }
            } catch (

            IOException exception) {
                System.out.println(exception.getMessage());
            }

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

    }

    public static String formatFio(String fio) {
        String[] splited = fio.split(" ");
        String result = "";
        for (int i = 0, cnt = 0; i < splited.length; i++) {
            if (splited[i].length() != 0) {
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

    public static boolean includes(char[] array, char chr) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == chr) {
                return true;
            }
        }
        return false;
    }
}
