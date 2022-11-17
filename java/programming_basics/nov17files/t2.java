import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//вывести фамилии имена и номера тех людей кому не меньше 18 лет
public class t2 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("file.txt");
        FileWriter fw = new FileWriter("write.txt");
        Scanner in = new Scanner(fr);

        String line;
        int linecnt = 0;
        while (in.hasNextLine()) {
            line = in.nextLine();
            linecnt++;

            String[] splited = line.split(":");

            if (splited.length != 3) {
                System.out.println("line " + linecnt + " wrong formated");
                continue;
            }

            String fio;
            String year;
            String number;
            
            
        }
    }
}