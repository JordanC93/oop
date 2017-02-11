package oophw;
import java.util.*;
import java.lang.Exception;

class BookCopy extends Book{
	private int Numcopy;
	private HashMap<String,LibraryCard> userswithbook; //hashmap containing all users who currently 
														//have a copy of book of current book object
	
	BookCopy(Book currentbook, int copies){
		super(currentbook.getISBN(), currentbook.getTitle(), currentbook.getAuthor());
		userswithbook=new HashMap<String,LibraryCard>();
		Numcopy=copies;

	}
	//resets the number of copies for a book if more copies are added or permanently removed from the library
	public void setNumcopy(int numofcopies){
		Numcopy=numofcopies;
	}
	//returns the number of copies left
	public int getNumcopy(){
		return Numcopy;
	}
	//checks if a book is instock or not
	boolean instock(BookCopy copy){
		if(copy.Numcopy==0){
			return false;
		}else{
			return true;
		}
	}
	//if book is in stock, it will add the user's librarycard to the hashmap to keep track of who
	//has a copy and uses the card owner's name as the key.
	boolean checkout(BookCopy copy, LibraryCard libcard){
		if(instock(copy)){
			userswithbook.put(libcard.getName(),libcard);
			Numcopy-=1;
			return true;
		}
		return false;
	}
	//remove's the person who checked out the book from the hashmap for said book 
	//and increments the copies by 1
	void returned(LibraryCard libcard){
		userswithbook.remove(libcard.getName());
		Numcopy+=1;
	}
	//doesn't work as intended
	void info(){
			bookinfo();
		System.out.println("Copies in stock: "+this.getNumcopy());
		System.out.println("\n");
	} 
	
	//will print who currently has checked out book object
	void whoHasBook(){
		System.out.println("The following people currently have \""+getTitle()+"\" checked out:");
		if(instock){
			Set<String> keySet = userswithbook.keySet();
			Iterator<String> keySetIterator = keySet.iterator();
			while (keySetIterator.hasNext()) {
   				String key = keySetIterator.next();
   				System.out.println(key);
			}
			return;
		}
		System.out.println("No user currently has this book checked out.");
	}
}
