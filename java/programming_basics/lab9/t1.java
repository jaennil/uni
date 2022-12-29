import java.time.LocalDateTime;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * t1
 */
public class t1 {
    public static void main(String[] args) {
        format();
    }

    public static void format() {
        try (FileWriter fw = new FileWriter("output.txt")) {
            try (FileReader fr = new FileReader("input.txt")) {
                Scanner file = new Scanner(fr);
                String line;
                for (int lineNumber = 1; file.hasNextLine(); lineNumber++) {
                    line = file.nextLine();
                    if (line.length() == 0) {
                        System.out.println("deleting empty line " + lineNumber);
                        continue;
                    }
                    String[] data = line.split(":");
                    if (data.length != 3) {
                        System.out.println(line + " has not enough ':'");
                        continue;
                    }
                    String fio = formatFio(data[0]);
                    if (!goodFioData(fio)) {
                        System.out.println(line + " has bad fio");
                        continue;
                    }
                    String date = formatDate(data[1]);
                    if (!goodDateData(date)) {
                        System.out.println(line + " has bad date");
                        continue;
                    }
                    if (isOlder(date, 20)) {
                        System.out.println(fio + " is older than 20");
                    } else {
                        System.out.println(fio + " is younger than 20");
                    }
                    String number = formatNumber(data[2]);
                    if (!goodNumberData(number)) {
                        System.out.println(line + " has bad number");
                        continue;
                    }
                    fw.write(fio + ":");
                    fw.write(date + ":");
                    fw.write(number + "\n");
                }
            } catch (IOException exception) {
                System.out.println(exception.getMessage());
            }

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static String formatFio(String fio) {
        fio = fio.replaceAll("\\s+", " ");
        if (fio.charAt(0) == ' ') {
            fio = fio.substring(1);
        }
        if (fio.charAt(fio.length() - 1) == ' ') {
            fio = fio.substring(0, fio.length() - 1);
        }
        return fio;
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
        char[] numberMarks = {'+', '(', ')', '-'};
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

    public static boolean isOlder(String burnDate, int age) {
        String[] data = burnDate.split("\\.");
        LocalDateTime ldt = LocalDateTime.now();
        int year = ldt.getYear();
        int person_year = Integer.parseInt(data[2]);
        int person_month = Integer.parseInt(data[1]);
        int person_day = Integer.parseInt(data[0]);
        if (year - person_year < age) {
            return false;
        } else if (year - person_year > age) {
            return true;
        } else {
            if (ldt.getMonthValue() > person_month) {
                return false;
            }
            return ldt.getDayOfMonth() <= person_day;
        }
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