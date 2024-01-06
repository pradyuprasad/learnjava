import java.util.ArrayList;
import java.util.InputMismatchException;

class DuplicateBookException extends Exception{
	public DuplicateBookException() {
		super("This book has already been added!");
	}
}

class BookNotThere extends Exception {
	public BookNotThere(){
		super("This book isn't there!");
	}
}



/* 1. add list of books borrowed as an ArrayList of books DONE 
 * 2. create add and remove functions to this DONE
 * 3. Create view function also for this 
 * */

class NegativeException extends Exception{
	public NegativeException(String message){
		super(message);
	}
}
public class Borrower{
	private String Name;
	private int BorrowerId;
	private int BorrowCount;
	private static int NextBorrowerId = 1;
	private ArrayList<Book> BookList;

	public static void main(String[] args){
	}

	public Borrower(String Name){
		try{
			this.Name = Name;
			this.BorrowCount = 0;
			this.BorrowerId = NextBorrowerId++;
		}
		catch (InputMismatchException ex){
			System.out.println("Wrong input type!");
		}
		catch (Exception ex){
			System.out.println("Error"+ ex);
		}
	}

	public String GetName(){
		return this.Name;
	}

	public int GetId(){
		return this.BorrowerId;
	}

	public int GetBorrowCount(){
		return this.BorrowCount;
	}
	public void IncreaseBorrow(){
		this.BorrowCount += 1;
	}
	public void DecreaseBorrow() throws NegativeException{
		if (this.BorrowCount <= 0){
			throw new NegativeException("You have not borrowed any books!"); 
		}
		else {
			this.BorrowCount -= 1;
		}
	}

	public boolean CheckBook(Book b){
		if (this.BookList.isEmpty()){
			return false;
		}
		else {
			for (Book k: this.BookList){
				if (k.equals(b)){
					return true;
				}
			}
			return false;
		}
	}	

	public void AddBook(Book b) throws DuplicateBookException{
		if (CheckBook(b)){
			throw new DuplicateBookException();
		}
		// check if b is already inside array
		else {
			this.BookList.add(b);
		}
	} 
	public void RemoveBook(Book b) throws BookNotThere{
		if (!CheckBook(b)){
			throw new BookNotThere();
		}
		else {
			this.BookList.remove(b);
		}
	} 
}

