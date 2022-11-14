import java.util.Scanner;
import java.util.InputMismatchException;

public class z3{
	public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int read_value;
        int max = -999999999;
        int max2 = -999999999;
        boolean m2f = false;
        for (int cnt = 0; true; cnt++){
          try {
            read_value = sc.nextInt();

            if (cnt == 0){
              max = read_value;
            }
            else{
              if (read_value > max){
                m2f = true;
                max2 = max;
                max = read_value;
              }
              else if (read_value < max){
                if (!m2f){
                m2f = true;
                max = max2;
                max2 = read_value;
                }
              }
            }
            if (m2f){
              System.out.println(max2);
            }
            else{
              System.out.println("No");
            }

          }
          catch (InputMismatchException e){
            System.out.println("wrong input");
            break;
          }
        }
        sc.close();
	}
}
