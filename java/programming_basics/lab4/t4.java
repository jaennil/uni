import java.util.Scanner;
import java.util.InputMismatchException;

//Напишите программу, вводящую последовательность целых чисел, и печатающую
//максимальную длину монотонного участка ее элементов.
//Пример: 1 -> 1, 1 1 -> 2, 1 1 2 -> 3, 1 1 2 2 -> 4, 1 1 2 2 3 -> 5, 1 1 2 2 3 4 -> 6,
//1 1 2 2 3 4 1 -> 6.
public class t4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int mode = 0;
        int previous = 0;
        try {
            previous = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("wrong input");
            scan.close();
            return;
        }
        int current;
        int length = 1;
        int max = 1;
        int similar = 1;
        while (true) {
            // print stuff
            System.out.println(max);
            // read console
            try {
                current = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("wrong input");
                break;
            }
            // check if read value is increasing/decreasing/constant
            switch (mode) {
                case 0:
                    if (current > previous) {
                        mode = 1;
                    } else if (current < previous) {
                        mode = -1;
                    }
                    length++;
                    break;
                case 1:
                    if (current < previous) {
                        mode = -1;
                        length = similar;
                        similar = 1;
                    } else {
                        similar++;
                        length++;
                    }
                    break;
                case -1:
                    if (current > previous) {
                        mode = 1;
                        length = similar;
                        similar = 1;
                    } else {
                        similar++;
                        length++;
                    }
                    break;
            }
            // update max
            if (length > max) {
                max = length;
            }
            previous = current;
        }
        scan.close();
    }
}
