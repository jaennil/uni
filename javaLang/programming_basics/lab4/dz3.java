import java.util.Scanner;
public class Dz3{
	public static void main(String [] args){
		Scanner scanner = new Scanner(System.in);

		System.out.println("enter amount of numbers");

		int numbers_amount = scanner.nextInt();

		int last_value = scanner.nextInt();
		int current_value = last_value;
		int max = 1;
		int temp_max = max;
		for (int i = 0; i < numbers_amount - 1; i++){
			current_value = scanner.nextInt();
			if (current_value == last_value){
				temp_max++;
			}
			else{
				if (temp_max > max){
					max = temp_max;
				}
				temp_max = 1;
			}
			last_value = current_value;
		}
		if (temp_max > max){
			max = temp_max;
		}
		System.out.println(max);
	}
}
