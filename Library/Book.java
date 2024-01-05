public class Book{
	String Title;
	String ISBN;
	String Author;
	boolean borrowed = false;
	
	public static void main(String[] args){
	}
	public Book(String Title, String ISBN, String Author){
		this.Title = Title;
		this.ISBN = ISBN;
		this.Author = Author;
		this.borrowed = false;
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
	public void BorrowBook(){
		this.borrowed = true;
		// need to make Borrower class and put it as an input to this function
	}
}
