import java.util.Scanner;
import java.util.InputMismatchException;

public class Z2{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		int read_value;
		int last_value = 0;
		int iterator = 0;
		int cnt = 0;
		while(true) {
			try {
				read_value = sc.nextInt();
				if (iterator == 0){
					last_value = read_value;
					cnt++;
				}
				else{
					if (read_value > last_value){
						cnt++;
					}
				}
        System.out.println(cnt);
        last_value = read_value;
			}
			catch(InputMismatchException e){
                System.out.println("wrong input");
				break;
			}
			finally {

			}
			iterator++;
		}
	}
}
