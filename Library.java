import java.util.ArrayList;

class Library {
	 private String adress;
	 private ArrayList<Book> books;
	 
	 public Library(String adress) {
		 this.adress=adress;
		 this.books= new ArrayList<>();
	 }
	 
	 public void addBook(Book book) {
		 books.add(book); 
	 }
	 
	 public static void printOpeningHours() {
		 System.out.println("Libraries are open daily from 9am to 5pm.");
	 }
	 
	 public void printAddress() {
		 System.out.println(adress);
	 }
	 
	 public String borrowBook(String title) {
		 
		 for(int i=0;i<books.size();i++) {
			 Book mybook = books.get(i);
			 String mytitle= mybook.getTitle();

			 if(mytitle.equals(title)) {
				 if(mybook.isBorrowed()==false) {
					 mybook.borrowed();
					 System.out.println("You successfully borrowed" + " " + mytitle);
						return null;
				 }
				 else {
						System.out.println("Sorry, this book is already borrowed.");
						return null;
					}
			}
				 
			 }
		 System.out.println("Sorry, this book is not in our catalog.");
		 return null; 	 
		 }
	 
	 public void printAvailableBooks() {
		 boolean empty=true;
		 for(int i=0;i<books.size();i++) {
			 
			 Book mybook=books.get(i);
			 
			 if(mybook.isBorrowed()==false) {
					System.out.println(mybook);
					empty=false;
			 }
			 
			 
		 }
		 if(empty) {
			 System.out.println("No book in catalog");
		 }
	 }
	 
	 public void returnBook(String title) {
		 
		 for(int i=0;i<books.size();i++) {
			 Book mybook=books.get(i);
			 String mytitle=mybook.getTitle();
			 
			 if(mytitle.equals(title)) {
				 if(mybook.isBorrowed()) {
					 mybook.returned();
					 System.out.println("You successfully returned" + " " + mytitle);
				 }
			 }
		 }
	 }
	 
	 
	 
	 
	 
	 
	 public static void main(String[] args) {
	        // Create two libraries
	        Library firstLibrary = new Library("10 Main St.");
	        Library secondLibrary = new Library("228 Liberty St.");

	        // Add four books to the first library
	        firstLibrary.addBook(new Book("The Da Vinci Code"));
	        firstLibrary.addBook(new Book("Le Petit Prince"));
	        firstLibrary.addBook(new Book("A Tale of Two Cities"));
	        firstLibrary.addBook(new Book("The Lord of the Rings"));

	        // Print opening hours and the addresses
	        System.out.println("Library hours:");
	        printOpeningHours();
	        System.out.println();

	        System.out.println("Library addresses:");
	        firstLibrary.printAddress();
	        secondLibrary.printAddress();
	        System.out.println();

	        // Try to borrow The Lords of the Rings from both libraries
	        System.out.println("Borrowing The Lord of the Rings:");
	        firstLibrary.borrowBook("The Lord of the Rings");
	        firstLibrary.borrowBook("The Lord of the Rings");
	        secondLibrary.borrowBook("The Lord of the Rings");
	        System.out.println();

	        // Print the titles of all available books from both libraries
	        System.out.println("Books available in the first library:");
	        firstLibrary.printAvailableBooks();
	        System.out.println();
	        System.out.println("Books available in the second library:");
	        secondLibrary.printAvailableBooks();
	        System.out.println();

	        // Return The Lords of the Rings to the first library
	        System.out.println("Returning The Lord of the Rings:");
	        firstLibrary.returnBook("The Lord of the Rings");
	        System.out.println();

	        // Print the titles of available from the first library
	        System.out.println("Books available in the first library:");
	        firstLibrary.printAvailableBooks();
	    }
}
