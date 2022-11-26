import java.util.HashMap;
import java.util.Scanner;

/**
 * t
 */
public class t1 {
  static Scanner in = new Scanner(System.in);
  public static void main(String[] args) {
    String input = in.nextLine();
    print(input);
  }

  public static void print(String number) {
    char[][] n0 = {{'-', '-'},
                   {'|', '|'},
                   {'|', '|'},
                   {' ', ' '},
                   {'|', '|'},
                   {'|', '|'},
                   {'-', '-'}};
    char[][] n1 = { { ' ' },
                    { '|' },
                    { '|' },
                    { ' ' },
                    { '|' },
                    { '|' },
                    { ' ' } };
    char[][] n2 = { { '-', '-' },
                    { ' ', '|' },
                    { ' ', '|' },
                    { '-', '-' },
                    { '|', ' ' },
                    { '|', ' ' },
                    { '-', '-' } };
    char[][] n3 = {{'-', '-'},
                   {' ', '|'},
                   {' ', '|'},
                   {'-', '-'},
                   {' ', '|'},
                   {' ', '|'},
                   {'-', '-'}};
    char[][] n4 = {{' ',' '},
                   {'|', '|'},
                   {'|', '|'},
                   {'-', '-'},
                   {' ', '|'},
                   {' ', '|'}};
    char[][] n5 = {{'-', '-'},
                   {'|', ' '},
                   {'|', ' '},
                   {'-', '-'},
                   {' ', '|'},
                   {' ', '|'},
                   {'-', '-'}};
    char[][] n6 = {{'-', '-'},
                   {'|', ' '},
                   {'|', ' '},
                   {'-', '-'},
                   {'|', '|'},
                   {'|', '|'},
                   {'-', '-'}};
    char[][] n7 = {{'-', '-'},
                   {' ', '|'},
                   {' ', '|'},
                   {' ', ' '},
                   {' ', '|'},
                   {' ', '|'}};
    char[][] n8 = {{'-', '-'},
                   {'|', '|'},
                   {'|', '|'},
                   {'-', '-'},
                   {'|', '|'},
                   {'|', '|'},
                   {'-', '-'}};
    char[][] n9 = {{'-', '-'},
                   {'|', '|'},
                   {'|', '|'},
                   {'-', '-'},
                   {' ', '|'},
                   {' ', '|'},
                   {'-', '-'}};

    HashMap<Character, char[][]> numbers = new HashMap<Character, char[][]>();
    numbers.put('0', n0);
    numbers.put('1', n1);
    numbers.put('2', n2);
    numbers.put('3', n3);
    numbers.put('4', n4);
    numbers.put('5', n5);
    numbers.put('6', n6);
    numbers.put('7', n7);
    numbers.put('8', n8);
    numbers.put('9', n9);

    char res[][] = numbers.get(number.charAt(0)).clone();
    for (int i = 1; i < number.length(); i++) {
      res = add(res, numbers.get(number.charAt(i)));
    }
    print(res);
  }
  public static void print(char[][] matrix) {
      System.out.println("");
      System.out.println("-print matrix start-");
      for (int i = 0; i < matrix.length; i++) {
          for (int j = 0; j < matrix[i].length; j++) {
              System.out.print(matrix[i][j] + " ");
          }
          System.out.println();
      }
      System.out.println("-print matrix end-");
      System.out.println("");
  }

  public static char[][] add(char[][] arr1, char[][] arr2) {
    char[][] res = new char[arr1.length][arr1[0].length + arr2[0].length];
    for (int i = 0; i < arr1.length; i++) {
      for (int j = 0; j < arr1[0].length; j++) {
        res[i][j] = arr1[i][j];
      }
    }
    
    for (int i = 0; i < arr2.length; i++) {
      for (int j = arr1[0].length, cnt = 0; j < arr1[0].length+arr2[0].length; j++, cnt++) {
        res[i][j] = arr2[i][cnt];
      }
    }
    return res;
  }
  
}
