import java.util.ArrayList;
class AlreadyBorrowed extends Exception {
	public AlreadyBorrowed (){
		super("This book has already been borrowed!");
	}
}

class BorrowLimitHit extends Exception {
	public BorrowLimitHit(){
		super("You have hit .out borrow limit!");
	}
}




public class Library{
	private static ArrayList<Book> Collection = new ArrayList<Book>();
	private static ArrayList<Borrower> Borrowers = new ArrayList<Borrower>();
	public static void main(String[] args){
		System.out.println("This is a library management system!");
		Book b1 = new Book("The Power Broker", "1234", "Robert Caro");
		Borrower pradyu = new Borrower("Pradyumna");
		try{
			BorrowBook(b1, pradyu);
			ReturnBook(b1, pradyu);
			pradyu.ViewBookList();
			
		}

		catch (Exception ex){
			System.out.println(ex);
			return;
		}
	}
	public static void NewBook(String Name, String ISBN, String Author){
		Book b = new Book(Name, ISBN, Author);
		Collection.add(b);
	}
	public static void ViewCollection(){
		for (Book book: Collection){
			System.out.println("Book: "+ book.GetTitle());
			System.out.println("Borrowing status is" + book.GetBorrowed() + "\n");
		}
	}

	public static void AddBorrower(String name){
		Borrower p = new Borrower(name);
		Borrowers.add(p);
	} 





	public static void BorrowBook(Book b, Borrower p) throws AlreadyBorrowed,BorrowLimitHit{
		/* Steps 
		 * Possibly check if the book exists? Depends on use case! We're probably only going to put variables as inputs so it should work!
		 * 1. Check if book is borrowed DONE
		 * 2. Check if max borrow limit has been hit DONE
		 * Actual Borrowing
		 * 1. Set borrowed to true DONE
		 * 1a. idk why this exception exists DONE
		 * 2. Set the borrower name to the name of the person borrowing DONE
		 * 3. Increase the person's borrowcount DONE
		 * 4. Put this into the person's borrowed books list DONE
		 */
		if (b.GetBorrowed() == true || b.GetBorrower() != ""){
			System.out.println("b.GetBorrowed is" + b.GetBorrowed());
			// check if book is borrowed
			throw new AlreadyBorrowed(); 
			// if it is borrowed, throw exception that it is borrowed
		}	
		else if (p.GetBorrowCount() >= p.BorrowLimit){
			throw new BorrowLimitHit();
		}
		else {
			try {
			b.SetBorrowed(true);
			boolean borrow_status = b.GetBorrowed();
			System.out.println("Borrowed has been set to"+borrow_status);
			}
			catch (Exception ex){
				System.out.println("Error!" + ex);

			}
			try{
				b.SetBorrower(p.GetName());
				String borrower = b.GetBorrower();
				System.out.println("Borrower has been set to "+ borrower);
			}

			catch (Exception ex){
				System.out.println("Error!"+ ex);
			}

			try {
				p.IncreaseBorrow();
				System.out.println("Borrow increased to " + p.GetBorrowCount());

			}
			catch (Exception ex){
				System.out.println("Error!"+ ex);
			}
			try {
				System.out.println("Staring the add");
				p.AddBook(b);
				System.out.println("Borrow list is now");
				p.ViewBookList();
			}
			catch (Exception ex){
				System.out.println("Error!"+ ex);
			}
		}
	}
	public static void ReturnBook(Book b, Borrower p) throws BookNotThere{
		/*
		 * Steps
		 * 1. Check if the book is in the person's borrowlist DONE
		 * 1b. If not, return an exception DONE
		 * 2. Set the borrowed of the book to false DONE
		 * 3. Set the borrower of the book to "" DONE
		 * 4. Decrease the borrow count by 1 DONE
		 * 5. Remove the book from the list DONE
		 * 6. batch these transactions if possible and allow for reverse? (Ask ChatGPT)
		 * */

		if (!p.CheckBook(b)){
			throw new BookNotThere();
		}
		else {
			try{
				b.SetBorrowed(false);
			}
			catch(Exception ex){
				System.out.println("Error!"+ ex);
			}
			try {
				b.SetBorrower("");
			}
			catch(Exception ex){
				System.out.println("Error!"+ ex);
			}
			try{
				p.DecreaseBorrow();
			}
			catch(Exception ex){
				System.out.println("Error!"+ ex);
			}
			try{
				p.RemoveBook(b);
			}
			catch(Exception ex){
				System.out.println("Error!"+ ex);
			}
		}
	} 
}
