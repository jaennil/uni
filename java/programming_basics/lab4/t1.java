import java.util.InputMismatchException;
import java.util.Scanner;

// Напишите программу, вводящую последовательность целых чисел, и печатающую
//      номер первого элемента, равного нулю, и нуль при отсутствии такого элемента в
//        последовательности.

public class t1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int index = 0;
        int input;
        for (int iterator = 0; true; iterator++) {
            try {
                input = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("wrong input");
                break;
            }
            if (index == 0 && input == 0) {
                index = iterator + 1;
            }
            System.out.println(index);
        }
        scan.close();
    }
}