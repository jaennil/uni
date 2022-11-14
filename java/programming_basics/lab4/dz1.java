import java.util.Scanner;
public class Dz1{
	public static void main(String [] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter amount of numbers");
		int amount = scanner.nextInt();
		int even_total = 0;
		int even_amount = 0;
		for (int i = 0; i < amount; i++){
			int value = scanner.nextInt();
			if (value % 2 == 0){
				even_total += value;
				even_amount++;
			}
		}
		System.out.println(even_total/even_amount);
		


	}
}
