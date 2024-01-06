class AlreadyBorrowed extends Exception {
	public AlreadyBorrowed (){
		super("This book has already been borrowed!");
	}
}


public class Library{
	public static void main(String[] args){
		System.out.println("This is a library management system!");
		Book b1 = new Book("The Power Broker", "1234", "Robert Caro");
		Borrower pradyu = new Borrower("Pradyumna");
	}
	public static void BorrowMethod(Book b, Borrower p) throws AlreadyBorrowed{
		/* Steps 
		 * 1. Check if book is borrowed
		 * 2. Check if max borrow limit has been hit
		 * Actual Borrowing
		 * 1. Set borrowed to true
		 * 1a. idk why this exception exists
		 * 2. Set the borrower name to the name of the person borrowing
		 * 3. Increase the person's borrow limit
		 * 4. Put this into the person's borrowed books list (how???)
		 *
		 *
		 *
		 */
		if (b.GetBorrowed() == true || b.GetBorrower() != ""){
			// check if book is borrowed
			throw new AlreadyBorrowed(); 
			// if it is borrowed, throw exception that it is borrowed
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
		}
	}
}

