package we.codered.rokomari.beans;


public class BookBean {

	private String title;
	private String author;
	private String isbn;
	private String publisher;
	
	
	protected BookBean() {
	}


	public BookBean(String title, String author, String isbn, String publisher) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.publisher = publisher;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	
	
	
}
