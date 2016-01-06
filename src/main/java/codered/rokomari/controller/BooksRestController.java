package codered.rokomari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import codered.rokomari.beans.BookBean;
import codered.rokomari.service.BookService;
import codered.rokomari.service.UserService;

@RestController
public class BooksRestController {

	@Autowired
	BookService bookService;

	// -------------------Retrieve All Books----------------------
	@RequestMapping(value = "/books/", method = RequestMethod.GET)
	public ResponseEntity<List<BookBean>> listAllBooks() {
		List<BookBean> books = bookService.getAllBooks();
		if (books.isEmpty()) {
			return new ResponseEntity<List<BookBean>>(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<BookBean>>(books, HttpStatus.OK);
	}

	// -------------------Retrieve Single Books--------------------
	@RequestMapping(value = "/books/{isbn}", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookBean> getUser(@PathVariable("isbn") String isbn) {
		BookBean book = bookService.getBookByIsbn(isbn);
		if (book == null) {
			System.out.println("Book with id " + isbn + " not found");
			return new ResponseEntity<BookBean>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<BookBean>(book, HttpStatus.OK);
	}

	
	
	// -------------------Create a Books-----------------------------
	@RequestMapping(value = "/books/create", method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody BookBean book, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating User " + book.getIsbn());

		if (bookService.isExits(book.getIsbn())) {
			System.out.println("A book with isbn " + book.getIsbn() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		bookService.saveBook(book);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{isbn}").buildAndExpand(book.getIsbn()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	
	
	
	// ------------------- Update a Books ------------------------------
	@RequestMapping(value = "/books/{isbn}", method = RequestMethod.PUT)
	public ResponseEntity<BookBean> updateBook(@PathVariable("isbn") String isbn, @RequestBody BookBean book) {
		System.out.println("Updating book " + book.getTitle());
		BookBean currentBean = bookService.getBookByIsbn(isbn);

		if (currentBean == null) {
			System.out.println("book with isbn " + isbn + " not found");
			return new ResponseEntity<BookBean>(HttpStatus.NOT_FOUND);
		}
		
		bookService.updateBook(currentBean);
		return new ResponseEntity<BookBean>(currentBean, HttpStatus.OK);
	}
	
	
	

	// ------------------- Delete a Book ----------------------------------
	@RequestMapping(value = "/books/{isbn}", method = RequestMethod.DELETE)
	public ResponseEntity<BookBean> deleteBook(@PathVariable("id") String isbn) {
		System.out.println("Fetching & Deleting book with isbn " + isbn);

		if (!bookService.isExits(isbn)) {
			System.out.println("Unable to delete. User with id " + isbn + " not found");
			return new ResponseEntity<BookBean>(HttpStatus.NOT_FOUND);
		}

		bookService.deleteBook(isbn);
		return new ResponseEntity<BookBean>(HttpStatus.NO_CONTENT);
	}

	
	
	// ------------------- Delete All Books --------------------------------
	@RequestMapping(value = "/books/", method = RequestMethod.DELETE)
	public ResponseEntity<BookBean> deleteAllBooks() {
		System.out.println("Deleting All Books");

		bookService.deleteAllBook();
		return new ResponseEntity<BookBean>(HttpStatus.NO_CONTENT);
	}

}
