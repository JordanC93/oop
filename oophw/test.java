package oophw;
import java.util.*;
import java.lang.Thread;
import java.lang.Exception;


class test{
	public static void main(String [] args) throws Exception{

		//creating the book objects 
		Book book1=new Book("978-4088736891","Jojo's Bizarre Adventure: Steel Ball Run","Hirohiko Araki");
		Book book2=new Book("978-0679417392","1984","George Orwell");
		Book book3=new Book("978-0802139924","The Warriors","Sol Yurick");
		Book book4=new Book("978-1632364210","The Ghost in the Shell 1 Deluxe Edition","Shirow Masamune");
		Book book5=new Book("978-1455539741","Hamilton: The Revolution","Lin-Manuel Miranda");
		Book book6=new Book("978-1501129742","End of Watch","Stephen King");
		Book book7=new Book("978-1305272422","Student Solutions Manual for Stewart's Single Variable Calculus: Early Transcendentals","James Stewart");
		Book book8=new Book("978-1878424310","The Four Agreements","Don Miguel Ruiz");
		Book book9=new Book("978-0785126348","Spider-Man: One More Day","J. Michael Straczynski");
		Book book10=new Book("978-0545834919","Peppa Goes Swimming","Scholastic");
		Book book11=new Book("978-1455519149","Egghead: Or, You Can't Survive on Ideas Alone","Bo Burnham");
			
		//making book copies for each book with the exception of 1 which will be 0 to test 
		//check ins when there are no copies
		BookCopy jojo=new BookCopy(book1,5);
		BookCopy ninet84=new BookCopy(book2,4);
		BookCopy warrior=new BookCopy(book3,2);
		BookCopy ghost=new BookCopy(book4,6);
		BookCopy hamilton=new BookCopy(book5,9);
		BookCopy watch=new BookCopy(book6,2);
		BookCopy calc=new BookCopy(book7,0);
		BookCopy agreement=new BookCopy(book8,3);
		BookCopy spiderman=new BookCopy(book9,9);
		BookCopy peppa=new BookCopy(book10,1);
		BookCopy egghead=new BookCopy(book11,7);

		LibraryCard veronica=new LibraryCard("Veronica Mars");
		LibraryCard ashley= new LibraryCard("Ashley Williams");
		LibraryCard aaron=new LibraryCard("Aaron Burr");

		printallbooks(jojo,ninet84,warrior,ghost,hamilton,watch,calc,agreement,spiderman,peppa,egghead);
		libcardprint(veronica,ashley,aaron);

		System.out.println("----- testing book checkout -----");
		//veronica's checkouts
		veronica.bookcheckout(jojo);
		veronica.bookcheckout(egghead);
		veronica.bookcheckout(ghost);
		veronica.bookcheckout(warrior);
		//Aaron's checkouts
		aaron.bookcheckout(hamilton);
		//Ashley's checkouts
		ashley.bookcheckout(calc);
		ashley.bookcheckout(jojo);
		ashley.bookcheckout(egghead);
		System.out.println("----- testing bookcopy of who currently has the book -----");
		jojo.whoHasBook();
		
		//user info after book checkout
		libcardprint(veronica,ashley,aaron);
		printallbooks(jojo,ninet84,warrior,ghost,hamilton,watch,calc,agreement,spiderman,peppa,egghead);
		
		System.out.println("----- testing book check -----");
		veronica.returnbook(jojo);
		veronica.returnbook(ghost);
		aaron.returnbook(ninet84);
		ashley.returnbook(spiderman);
		
		libcardprint(veronica,ashley,aaron);
		printallbooks(jojo,ninet84,warrior,ghost,hamilton,watch,calc,agreement,spiderman,peppa,egghead);
	}

	//prints library cards
	static void libcardprint(LibraryCard veronica,LibraryCard ashley,LibraryCard aaron){
		veronica.userinfo();
		ashley.userinfo();
		aaron.userinfo();
		System.out.println("\n");
	}
	//prints book titles and the amount currenty in the library
	static void printallbooks(BookCopy jojo,BookCopy ninet84, BookCopy warrior,BookCopy ghost, BookCopy hamilton,BookCopy watch,BookCopy calc,
					BookCopy agreement,BookCopy spiderman,BookCopy peppa,BookCopy egghead)
	{
		jojo.info();
		ninet84.info();
		warrior.info();
		ghost.info();
		hamilton.info();
		watch.info();
		calc.info();
		agreement.info();
		spiderman.info();
		peppa.info();
		egghead.info();
	}
}