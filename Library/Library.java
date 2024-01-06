class AlreadyBorrowed extends Exception {
	public AlreadyBorrowed (){
		super("This book has already been borrowed!");
	}
}

class BorrowLimitHit extends Exception {
	public BorrowLimitHit(){
		super("You have hit your borrow limit!");
	}
}




public class Library{
	public static void main(String[] args){
		System.out.println("This is a library management system!");
		Book b1 = new Book("The Power Broker", "1234", "Robert Caro");
		Borrower pradyu = new Borrower("Pradyumna");
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
			}
			catch (IllegalArgumentException ex){
				System.out.println("Error!" + ex);

			}
			try{
				b.SetBorrower(p.GetName());
			}

			catch (Exception ex){
				System.out.println("Error!"+ ex);
			}

			try {
				p.IncreaseBorrow();
			}
			catch (Exception ex){
				System.out.println("Error!"+ ex);
			}
			try {
				p.AddBook(b);
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
