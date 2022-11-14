import java.util.Scanner;
public class Dz2{
	public static void main(String [] args){
		Scanner scanner = new Scanner(System.in);

		System.out.println("enter amount of numbers");

		int numbers_amount = scanner.nextInt();

		int read_value = scanner.nextInt();
		int max = read_value;
		int max_amount = 1;
		for (int i = 0; i < numbers_amount - 1; i++){
			read_value = scanner.nextInt();
			if (read_value > max){
				max = read_value;
				max_amount = 1;
			}
			else if (read_value == max){
				max_amount++;
			}
		}
		System.out.println(max);
		System.out.println(max_amount);
	}
}
			

		
