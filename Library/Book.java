import java.util.InputMismatchException;
public class Book{
	private String Title;
	private String ISBN;
	private String Author;
	private boolean borrowed = false;
	private String BorrowPerson = "";
	
	public static void main(String[] args){
	}
	public Book(String Title, String ISBN, String Author){
		try {
			this.Title = Title;
			this.ISBN = ISBN;
			this.Author = Author;
			this.borrowed = false;
		}
		catch (InputMismatchException ex){
			System.out.println("Wrong input type!");
		}

		catch (Exception ex){
			System.out.println("Error"+ ex);
		}

	}
	
	public void SetBorrower(String Name){
		if (this.BorrowPerson != "" || this.borrowed == true){
			throw new IllegalArgumentException("The same book cannot be borrowed by multiple people at once!");
		}
		else {
			this.BorrowPerson = Name;
		}
	}
	public String GetBorrower(){
		return this.BorrowPerson;
	}
	public String GetTitle(){
		return this.Title;
	}
	public String GetISBN(){
		return this.ISBN;
	}
	public String GetAuthor(){
		return this.Author;
	}
	public boolean GetBorrowed(){
		return this.borrowed;
	}
	public void SetBorrowed(boolean status){
		this.borrowed = status;
	}
}
