public class Library{
	public static void main(String[] args){
		System.out.println("This is a library management system!");
		Book b1 = new Book("The Power Broker", "1234", "Rober Caro");
		Borrower pradyu = new Borrower("Pradyumna");
	}
	public static void Borrow(Book b, Borrower p){
		if (b.GetBorrowed == true){
			throw new 
		}	
		else {
			try {
			b.SetBorrowed(true);
			}
			catch (IllegalIllegalArgumentException ex) {
				System.out.Println("Error!" + ex)

			}
			b.SetBorrower(p.GetName());
			p.
		}
	}
	
	
}

