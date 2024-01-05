public class Library{
	public static void main(String[] args){
		System.out.println("This is a library management system!");
	}

	private class Book {
		String BookName;
		String BookISBN;
		String BookAuthor;
		boolean Borrowed = false; 

		public Book (String BookName, String BookISBN, String BookAuthor){
			this.BookName = BookName;
			this.BookISBN = BookISBN;
			this.BookAuthor = BookAuthor;
			
		}
	}
	
}

