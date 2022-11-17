package programming_basics;

import java.util.Scanner;

public class global {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("enter 1 for generate random matrix or 2 for input matrix from console");

        int choice = scanInt();

        while (choice != 1 && choice != 2) {
            System.out.print("Enter 1 or 2: ");
            choice = scanInt();
        }

        int[][] matrix = handleChoice(choice);

        print("enter row number to delete: ");
        int dRowNum = scanInt();

        task(matrix, dRowNum);

        scan.close();
    }

    public static void task(int[][] matrix, int dRowNum) {
        System.out.println("after task:");

        matrix = deleteRow(matrix, dRowNum - 1);

        print(matrix);
    }

    public static int[][] handleChoice(int choice) {
        int[][] matrix = new int[0][0];

        switch (choice) {
            case (1):
                print("Enter amount of rows: ");
                int rows = scanInt();

                print("Enter amount of columns: ");
                int columns = scanInt();

                matrix = generateMatrix(rows, columns, -500, 500);

                break;

            case (2):
                matrix = inputMatrix();

                break;
        }

        return matrix;

    }

    public static int[][] generateMatrix(int rows, int columns, int min, int max) {
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = (int) (Math.random() * (max - min) + min);
            }
        }
        System.out.println("generated matrix:");
        print(matrix);

        return matrix;
    }

    public static int[][] generateMatrix(int degree, int min, int max) {
        return generateMatrix(degree, degree, min, max);
    }

    public static int[][] inputMatrix() {
        System.out.print("Enter amount of rows: ");
        int rows = scanInt();

        System.out.print("Enter amount of columns: ");
        int columns = scanInt();

        println("example input for 3 rows and 4 columns: ");
        println("1 2 3 4");
        println("5 6 7 8");
        println("4 3 2 1");
        println();

        int[][] matrix = new int[rows][columns];

        String row;
        String[] splited_row;
        for (int i = 0; i < rows; i++) {
            row = scan.nextLine();
            splited_row = row.split(" ");

            for (int j = 0; j < splited_row.length; j++) {
                matrix[i][j] = Integer.parseInt(splited_row[j]);
            }
        }
        return matrix;
    }

    public static int scanInt() {
        int read_value;
        try {
            read_value = Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Input value must be integer");
            return scanInt();
        }
        return read_value;
    }

    public static void print(Object text) {
        System.out.print(text);
    }

    public static void println(Object text) {
        System.out.println(text);
    }

    public static void println() {
        System.out.println();
    }

    public static void print(int[][] matrix) {
        int longestValue = longestValue(matrix);
        println("");
        System.out.println("-print matrix start-");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                for (int q = 0; q < longestValue - String.valueOf(matrix[i][j]).length() + 1; q++) {
                    print(" ");
                }
            }
            System.out.println();
        }
        System.out.println("-print matrix end-");
        println("");
    }

    public static void print(int[] array) {
        println("");
        System.out.println("-print array start-");
        for (int i = 0; i < array.length; i++) {
            print(array[i] + " ");
        }
        println();
        System.out.println("-print array end-");
        println("");
    }

    public static int longestValue(int[] array) {
        int max = 0;
        int length;
        for (int i = 0; i < array.length; i++) {
            length = String.valueOf(array[i]).length();
            if (length > max) {
                max = length;
            }
        }
        return max;
    }

    public static int longestValue(int[][] matrix) {
        int max = 0;
        int length;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                length = String.valueOf(matrix[i][j]).length();
                if (length > max) {
                    max = length;
                }
            }
        }
        return max;
    }

    public static int count(int[] array, int value) {
        int amount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                amount++;
            }
        }
        return amount;
    }

    public static int max(int[] array) {
        int max = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }

    public static int max(int matrix[][]) {
        int max = matrix[0][0];

        int metrics[] = getMetrics(matrix);
        int rows = metrics[0];
        int columns = metrics[1];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }

        return max;
    }

    public static int min(int[] array) {
        int min = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }

    public static int min(int matrix[][]) {
        int min = matrix[0][0];

        int metrics[] = getMetrics(matrix);
        int rows = metrics[0];
        int columns = metrics[1];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
        }

        return min;
    }

    public static double average(int[] array) {
        return sum(array) / (double) array.length;
    }

    public static int sum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static int[] getMetrics(int[][] matrix) {
        // rows, columns
        int[] ret = { matrix.length, matrix[0].length };
        return ret;
    }

    public static boolean increase(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static int find(int array[], int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }

        return -1;
    }

    public static int[] find(int matrix[][], int value) {
        int ret[] = { -1, -1 };
        int metrics[] = getMetrics(matrix);
        int rows = metrics[0];
        int columns = metrics[1];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == value) {
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                }
            }
        }

        return ret;
    }

    public static int[][] swapColumns(int matrix[][], int colIdx1, int colIdx2) {
        int rows = matrix.length;

        int tempColumn[] = new int[rows];
        for (int i = 0; i < rows; i++) {
            tempColumn[i] = matrix[i][colIdx1];
        }

        for (int i = 0; i < rows; i++) {
            matrix[i][colIdx1] = matrix[i][colIdx2];
            matrix[i][colIdx2] = tempColumn[i];
        }

        return matrix;
    }

    public static int[][] swapRows(int matrix[][], int idx1, int idx2) {
        int columns = matrix[0].length;

        int tempRow[] = new int[columns];
        for (int i = 0; i < columns; i++) {
            tempRow[i] = matrix[idx1][i];
        }

        for (int i = 0; i < columns; i++) {
            matrix[idx1][i] = matrix[idx2][i];
            matrix[idx2][i] = tempRow[i];
        }

        return matrix;
    }

    public static int[][] deleteRow(int matrix[][], int index) {
        int[] metrics = getMetrics(matrix);
        int rows = metrics[0];
        int columns = metrics[1];
        int newMatrix[][] = new int[rows - 1][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i != index) {
                    newMatrix[i][j] = matrix[i][j];
                }
            }
        }
        return newMatrix;
    }

    public static int find(String string, char chr) {
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == chr) {
                return i;
            }
        }
        return -1;
    }

    public static boolean matches(String str1, String str2, int amount) {
        int str1len = str1.length();
        int str2len = str2.length();

        if (amount > str1len || amount > str2len) {
            return false;
        }

        for (int i = 0; i < amount; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static short compare(String str1, String str2) {
        String[] alphabets = new String[] { "abcdefghijklmnopqrstuvwxyz", "ABCDEFGHIJKLMNOPQRSTUVWXYZ" };

        int str1len = str1.length();
        int str2len = str2.length();

        int mn;
        if (str1len > str2len) {
            mn = str2len;
        } else {
            mn = str1len;
        }

        int char1index = 0;
        int char2index = 0;
        for (int i = 0; i < mn; i++) {
            for (int j = 0; j < 4; j++) {
                char1index = find(alphabets[j], str1.charAt(i));
                if (char1index != -1) {
                    break;
                }
            }
            for (int j = 0; j < 4; j++) {
                char2index = find(alphabets[j], str2.charAt(i));
                if (char2index != -1) {
                    break;
                }
            }

            if (char1index == -1 || char2index == -1) {
                throw new Error("Can't find symbol in alphabets");
            } else if (char1index > char2index) {
                return 1;
            } else if (char1index < char2index) {
                return -1;
            } else {
                continue;
            }
        }

        return 0;
    }

    public static boolean includes(String string, char chr) {
        for (int i = 0; i < string.length(); i++) {
            return true;
        }
        return false;
    }
}
