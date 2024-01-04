import java.util.Scanner;
public class Add {
	public static void main (String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("What's the first number??");
		int number = scanner.nextLine();
		System.out.println(number + 1);
		scanner.close();
	} 

}
