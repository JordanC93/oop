package oophw;
import java.util.*;
import java.lang.Exception;

class LibraryCard{
	private int ID; 
	private static int starterID= (int)(Math.random()*10000+1); //will generate a random ID from 1-10,000. 
	private String name;
	private HashMap<String, BookCopy> bookschecked; //will keep track of all books the current user has checked out.
	//private LibraryCard();
	public int getID(){
		return ID;
	}	
	public String getName(){
		return name;
	}
	LibraryCard(String username){
		ID=starterID++; //will create  a unique ID
		this.name=username;
		bookschecked=new HashMap<String,BookCopy>();
	}

	//will attempt to checkout a copy of a book, if successful, will add it to the user's hashmap of all books checked out
	//if unsuccessful it will throw and then catch an exception. 
	void bookcheckout(BookCopy copy){
		try{
			if(copy.checkout(copy,this)){
				bookschecked.put(copy.getTitle(), copy);
			}
			else
				throw new Exception("Unable to checkout, please try again later.");
		}catch (Exception e){System.out.println(e.getMessage());}
	}
	//checks if user currently has the book, if (s)he does, it will remove the copy from the user's hashmap
	//and call bookcopy to return the copy.
	void returnbook(BookCopy copy){
		try{
			if(bookschecked.containsKey(copy.getTitle())){
				bookschecked.remove(copy.getTitle());
				copy.returned(this);
				return;
			}else
			{
				throw new Exception("Unable to remove "+copy.getTitle()+
							" ("+copy.getISBN()+"). Please try again later.");
			}
		}catch(Exception error){System.out.println(error.getMessage());
			}
	}
	//prints the library card owner's name and ID
	void userinfo(){
		System.out.print("Name:"+this.getName()+"\n"+"ID: "+this.getID()+"\n"+"Current books checked out:\n");
		if(bookschecked.isEmpty()){
			System.out.println("no books are currently checked out."+"\n");
			return;
		}
		Set<String> keySet = bookschecked.keySet();
		Iterator<String> keySetIterator = keySet.iterator();
		while (keySetIterator.hasNext()){
   				String book = keySetIterator.next();
   				System.out.println(book);
		}
		System.out.println("\n");
	}

	//testing for library card
	public static void main(String [] args){
		Book test=new Book("11-11-11","Biggest Adventure of All","John Doe");
		BookCopy copy=new BookCopy(test,10);
		LibraryCard greg=new LibraryCard("Greg");
		greg.userinfo();
		LibraryCard lisa=new LibraryCard("Lisa");
		lisa.userinfo();
		System.out.println("Biggest Adventure of All has: "+copy.getNumcopy()+" copies");
		greg.bookcheckout(copy);
		System.out.println("Biggest Adventure of All has: "+copy.getNumcopy()+" copies(after taking book out");
		greg.userinfo();
		greg.returnbook(copy);
		System.out.println("Biggest Adventure of All has: "+copy.getNumcopy()+" copies (after returning book");
		greg.userinfo();
		greg.returnbook(copy);	
		System.out.println("program continues after exception");
	}
}