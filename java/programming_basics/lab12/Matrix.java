import java.util.Scanner;

public class Matrix {
    private double [][] matrix;

    private int rows, columns;
    static Scanner in = new Scanner(System.in);
    public Matrix(int rows, int columns) {
        matrix = new double[rows][columns];

        for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = 0;
                }
            }
    }

    public Matrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public Matrix() {
        promptRows();
        promptColumns();
        matrix = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            double[] row = promptRow(i);
            System.arraycopy(row, 0, matrix[i], 0, columns);
        }
    }

    public void add(Matrix other) {
        if (matrix.length != other.matrix.length || matrix[0].length != other.matrix[0].length) {
            System.out.println("Matrices must be the same size");
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] += other.matrix[i][j];
            }
        }
    }

    public static Matrix add (Matrix a, Matrix b) {
        if (a.matrix.length != b.matrix.length || a.matrix[0].length != b.matrix[0].length) {
            System.out.println("Matrices must be the same size");
            return null;
        }
        Matrix result = new Matrix(a.matrix.length, a.matrix[0].length);
        for (int i = 0; i < a.matrix.length; i++) {
            for (int j = 0; j < a.matrix[i].length; j++) {
                result.matrix[i][j] = a.matrix[i][j] + b.matrix[i][j];
            }
        }
        return result;
    }

    public void multiply(double number) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] *= number;
            }
        }
    }

    public static Matrix multiply(Matrix a, double number) {
        Matrix result = new Matrix(a.matrix.length, a.matrix[0].length);
        for (int i = 0; i < a.matrix.length; i++) {
            for (int j = 0; j < a.matrix[i].length; j++) {
                result.matrix[i][j] = a.matrix[i][j] * number;
            }
        }
        return result;
    }

    public void multiply(Matrix other) {
        if (matrix[0].length != other.matrix.length) {
            System.out.println("Matrices must be compatible");
            return;
        }
        double[][] result = new double[matrix.length][other.matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < other.matrix[0].length; j++) {
                for (int k = 0; k < matrix[0].length; k++) {
                    result[i][j] += matrix[i][k] * other.matrix[k][j];
                }
            }
        }
        matrix = result;
    }

    public static Matrix multiply(Matrix a, Matrix b) {
        if (a.matrix[0].length != b.matrix.length) {
            System.out.println("Matrices must be compatible");
            return null;
        }
        Matrix result = new Matrix(a.matrix.length, b.matrix[0].length);
        for (int i = 0; i < a.matrix.length; i++) {
            for (int j = 0; j < b.matrix[0].length; j++) {
                for (int k = 0; k < a.matrix[0].length; k++) {
                    result.matrix[i][j] += a.matrix[i][k] * b.matrix[k][j];
                }
            }
        }
        return result;
    }

    private double[] promptRow(int index) {
        System.out.print("Enter row " + (index + 1) + ": ");
        String row = in.nextLine();
        if (!allNumbers(row)) {
            System.out.println("Invalid input. Please enter only numbers.");
            return promptRow(index);
        }
        String[] rowArray = row.split(" ");
        double[] result = new double[columns];
        for (int i = 0; i < columns; i++) {
            result[i] = Double.parseDouble(rowArray[i]);
        }
        return result;
    }

    private void promptRows() {
        System.out.print("Enter the number of rows: ");
        try {
            rows = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Rows must me an integer. Try again");
            promptRows();
        }
        if (rows < 1) {
            System.out.println("rows amount must be more than 0. Try again");
            promptRows();
        }
    }

    private void promptColumns() {
        System.out.print("Enter the number of columns: ");
        try {
            columns = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Columns must me an integer. Try again");
            promptColumns();
        }
        if (columns < 1) {
            System.out.println("columns amount must be more than 0. Try again");
            promptColumns();
        }
    }

    private boolean allNumbers(String string) {
        for (String word : string.split(" ")) {
            if (!word.matches("^(-?\\d+\\.\\d+)|(-?\\d+)$")) {
                System.out.println("DEBUG: regex not matched");
                return false;
            }
        }
        return true;
    }
    public void generate(double min, double max) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Math.random() * (max - min) + min;
            }
        }
    }

    public void print() {
        for (double[] row : matrix) {
            for (double number : row) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


}
