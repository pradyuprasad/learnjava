import java.util.Scanner;
import java.util.InputMismatchException;
public class Add {
	public static void main (String[] args){
		Scanner scanner = new Scanner(System.in);
		int n1 = 0, n2 = 0;
		boolean ValidInput = false;
		while (!ValidInput){
			try {
				System.out.println("What is the first number?");
				n1 = scanner.nextInt();
				ValidInput = true;
			}
			catch (InputMismatchException ex){
				System.out.println("That input was not permitted!");
				scanner.next();
			}
			catch (Exception ex){
				System.out.println("Error"+ ex);
				scanner.next();
			}
		}
		ValidInput = false;
		while (!ValidInput){
			try {
				System.out.println("What is the second number?");
				n2 = scanner.nextInt();
				ValidInput = true;
			}
			catch (InputMismatchException ex){
				System.out.println("That input was not permitted!");
				scanner.next();
			}
			catch (Exception ex){
				System.out.println("Error"+ ex);
				scanner.next();
			}
		}

		int sum = n1 + n2;

		System.out.println("The sum of your two numbers is "+ sum);
	}
}
