public class Borrower{
	private String Name;
	private int BorrowerId;
	private int BorrowCount;
	private static int NextBorrowerId = 1;

	public static void main(String[] args){
	}

	public Borrower(String Name){
		this.Name = Name;
		this.BorrowCount = 0;
		this.BorrowerId = NextBorrowerId++;
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
}
