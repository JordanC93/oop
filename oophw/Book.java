package oophw;
import java.util.*;
import java.lang.*;

class Book{
	private String ISBN, author, title;	 

	public Book(String isbn1, String title1, String author1){
		this.ISBN=isbn1;
		this.title=title1;
		this.author=author1;
	}
	public String getISBN(){
		return ISBN;
	}
	public String getAuthor(){
		return author;
	}
	public String getTitle(){
		return title;
	}
	public void bookinfo(){
		System.out.print(this.getTitle());
		System.out.println("\n"+this.getAuthor());
		System.out.print(this.getISBN()+"\n");
	}
	 //test case to make sure Book works properly
	public static void main(String args[]){
		Book book1= new Book("12345","Testing the Title", "Jordan");
		System.out.print(book1.getTitle());
		System.out.println("\n"+book1.getAuthor());
		System.out.print(book1.getISBN()+"\n");
	}
	
}
