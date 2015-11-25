package we.codered.rokomari.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import we.codered.rokomari.dao.BooksDao;
import we.codered.rokomari.entity.Books;

@Service("bookService")
public class BookService {

	@Autowired
	private BooksDao dao;

	public List<Books> getBook(){
		return dao.findAll();
	}
	
	public void createBook(){
		/*Books book = new Books();
		book.setTitle("কাকাবাবু সমগ্র ২");
		book.setIsbn("9523252155");
		book.setCategories("Thriller, Teen-age");
		book.setAuthorIdFk();
		dao.create();*/
	}
}
