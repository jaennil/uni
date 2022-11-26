import java.util.HashMap;
import java.util.Scanner;

/**
 * t
 */
public class t1 {
  static Scanner in = new Scanner(System.in);

  public static void main(String[] args) {
    String input = in.nextLine();
    printCalcNumber(input);
  }

  public static void printCalcNumber(String number) {
    char[][] n0 = { { ' ', '_', '_', '_', '_', ' ' },
        { '|', ' ', ' ', ' ', ' ', '|' },
        { '|', ' ', ' ', ' ', ' ', '|' },
        { '|', ' ', ' ', ' ', ' ', '|' },
        { '|', ' ', ' ', ' ', ' ', '|' },
        { '|', ' ', ' ', ' ', ' ', '|' },
        { '|', '_', '_', '_', '_', '|' } };
    char[][] n1 = { { ' ', ' ', ' ', ' ' },
        { ' ', ' ', '/', '|' },
        { ' ', '/', ' ', '|' },
        { '/', ' ', ' ', '|' },
        { ' ', ' ', ' ', '|' },
        { ' ', ' ', ' ', '|' },
        { ' ', ' ', ' ', '|' } };
    char[][] n2 = { { ' ', '_', '_', '_', ' ' },
        { ' ', ' ', ' ', ' ', '|' },
        { ' ', ' ', ' ', ' ', '|' },
        { ' ', '_', '_', '_', '|' },
        { '|', ' ', ' ', ' ', ' ' },
        { '|', ' ', ' ', ' ', ' ' },
        { '|', '_', '_', '_', ' ' } };
    char[][] n3 = { { '_', '_', '_', ' ' },
        { ' ', ' ', ' ', '|' },
        { ' ', ' ', ' ', '|' },
        { '_', '_', '_', '|' },
        { ' ', ' ', ' ', '|' },
        { ' ', ' ', ' ', '|' },
        { '_', '_', '_', '|' } };
    char[][] n4 = { { ' ', ' ', ' ', ' ', ' ' },
        { '|', ' ', ' ', ' ', '|' },
        { '|', ' ', ' ', ' ', '|' },
        { '|', '_', '_', '_', '|' },
        { ' ', ' ', ' ', ' ', '|' },
        { ' ', ' ', ' ', ' ', '|' },
        { ' ', ' ', ' ', ' ', '|' } };
    char[][] n5 = { { ' ', '_', '_', '_', ' ' },
        { '|', ' ', ' ', ' ', ' ' },
        { '|', ' ', ' ', ' ', ' ' },
        { '|', '_', '_', '_', ' ' },
        { ' ', ' ', ' ', ' ', '|' },
        { ' ', ' ', ' ', ' ', '|' },
        { ' ', '_', '_', '_', '|' } };
    char[][] n6 = { { ' ', '_', '_', '_', ' ' },
        { '|', ' ', ' ', ' ', ' ' },
        { '|', ' ', ' ', ' ', ' ' },
        { '|', '_', '_', '_', ' ' },
        { '|', ' ', ' ', ' ', '|' },
        { '|', ' ', ' ', ' ', '|' },
        { '|', '_', '_', '_', '|' } };
    char[][] n7 = { { ' ', '_', '_', '_', ' ' },
        { ' ', ' ', ' ', ' ', '|' },
        { ' ', ' ', ' ', ' ', '|' },
        { ' ', ' ', ' ', ' ', '|' },
        { ' ', ' ', ' ', ' ', '|' },
        { ' ', ' ', ' ', ' ', '|' },
        { ' ', ' ', ' ', ' ', '|' } };
    char[][] n8 = { { ' ', '_', '_', '_', ' ' },
        { '|', ' ', ' ', ' ', '|' },
        { '|', ' ', ' ', ' ', '|' },
        { '|', '_', '_', '_', '|' },
        { '|', ' ', ' ', ' ', '|' },
        { '|', ' ', ' ', ' ', '|' },
        { '|', '_', '_', '_', '|' } };
    char[][] n9 = { { ' ', '_', '_', '_', ' ' },
        { '|', ' ', ' ', ' ', '|' },
        { '|', ' ', ' ', ' ', '|' },
        { '|', '_', '_', '_', '|' },
        { ' ', ' ', ' ', ' ', '|' },
        { ' ', ' ', ' ', ' ', '|' },
        { ' ', '_', '_', '_', '|' } };

    HashMap<Character, char[][]> numbers = new HashMap<Character, char[][]>() {
      {
        put('0', n0);
        put('1', n1);
        put('2', n2);
        put('3', n3);
        put('4', n4);
        put('5', n5);
        put('6', n6);
        put('7', n7);
        put('8', n8);
        put('9', n9);
      }
    };

    char res[][] = numbers.get(number.charAt(0)).clone();
    for (int i = 1; i < number.length(); i++) {
      res = add(res, numbers.get(number.charAt(i)));
    }
    print(res);
  }

  public static void print(char[][] matrix) {
    System.out.println();
    System.out.println("-print matrix start-");
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j]);
      }
      System.out.println();
    }
    System.out.println();
    System.out.println("-print matrix end-");
    System.out.println();
  }

  public static char[][] add(char[][] arr1, char[][] arr2) {
    int mx = arr1.length > arr2.length ? arr1.length : arr2.length;
    char[][] res = new char[mx][arr1[0].length + arr2[0].length + 1];
    for (int i = 0; i < arr1.length; i++) {
      for (int j = 0; j < arr1[0].length; j++) {
        res[i][j] = arr1[i][j];
      }
      res[i][arr1[0].length] = ' ';
    }

    for (int i = 0; i < arr2.length; i++) {
      for (int j = arr1[0].length + 1, cnt = 0; j < arr1[0].length + arr2[0].length + 1; j++, cnt++) {
        res[i][j] = arr2[i][cnt];
      }
    }
    return res;
  }

}
