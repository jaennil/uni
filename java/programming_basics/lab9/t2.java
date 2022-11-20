import java.time.LocalDateTime;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * t2
 */
public class t2 {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(new FileReader("output.txt"))) {
            String line;
            while (in.hasNextLine()) {
                line = in.nextLine();
                String[] splited = line.split(":");

                String date = splited[1];
                String fio = splited[0];

                if (isOlder(date, 20)) {
                    System.out.println(fio);
                }
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static boolean isOlder(String burnDate, int age) {
        String[] splited = burnDate.split("\\.");
        LocalDateTime ldt = LocalDateTime.now();

        int year = ldt.getYear();

        int burnYear = Integer.parseInt(splited[2]);
        int burnMonth = Integer.parseInt(splited[1]);
        int burnDay = Integer.parseInt(splited[0]);

        if (year - burnYear < age) {
            return false;
        } else if (year - burnYear > age) {
            return true;
        } else {
            if (ldt.getMonthValue() < burnMonth) {
                return false;
            }
            if (ldt.getDayOfMonth() < burnDay) {
                return false;
            }
            return true;
        }
    }
}