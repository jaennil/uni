import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class files {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("file.txt");
        FileWriter fw = new FileWriter("write.txt");
        Scanner in = new Scanner(fr);
        String line;
        while (in.hasNextLine()) {
            line = in.nextLine();
            String[] splited = line.split(" ");

            for (int i = 0; i < splited.length; i++) {
                String word = splited[i];
                int wordLen = word.length();
                char[] signs = { ',', '.', '!' };
                for (int j = 0; j < signs.length; j++) {
                    wordLen -= count(word, signs[j]);
                }
                if (wordLen == 3) {
                    for (int j = 0; j < word.length(); j++) {
                        // todo
                    }
                }
                fw.write(word + " ");
            }
            fw.write("\n");
        }
        fr.close();
        fw.close();
        in.close();
    }

    public static int count(String string, char chr) {
        int cnt = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == chr) {
                cnt++;
            }
        }
        return cnt;
    }

    public static boolean includes(String string, char chr) {
        for (int i = 0; i < string.length(); i++) {
            return true;
        }
        return false;
    }
}