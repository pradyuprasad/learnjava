import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;
public class GuessingGame {
	public static void main(String[] args){

		System.out.println("This is a guessing game!\nThe computer picks a random number between 1 and 100.\nYou try to guess that number, and the computer tells you if it is too high or too low. If you take more than 7 guesses, you lose!");
		Random rand = new Random();
		Scanner scanner = new Scanner(System.in);
		int rand_int = rand.nextInt(100)+1;
		int counter = 0;
		while (true){
			if (counter > 7){
				System.out.println("You have exceeded 7 guesses!");
				System.exit(0);
			}
			try {
				System.out.println("Please enter your guess");
				int guess = scanner.nextInt();
				if (guess == rand_int){
					counter += 1;
					System.out.println("This is the correct guess!\n");
					System.out.println("You took only "+ counter + " guesses");
					System.exit(0);
				}

				else if (guess > rand_int){
					System.out.println("Your guess is too high!\n");
					counter += 1;
					System.out.println("You have used up "+ counter + " guesses");
				}

				else {
					counter += 1;
					System.out.println("You have used up "+ counter + " guesses");
					System.out.println("Your guess is too low!\n");

				}
			}
				
			catch (InputMismatchException ex){
				System.out.println("Please enter a number only!");
				scanner.next();
			}
			catch (Exception ex) {
				System.out.println("Error: "+ ex);
			}
		}
	}

}
