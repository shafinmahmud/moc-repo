package we.codered.rokomari.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import we.codered.rokomari.dao.BooksDao;
import we.codered.rokomari.entity.Books;

@Service("bookService")
public class BookService {

	private BooksDao dao;

	@Autowired
	public void setDao(BooksDao dao) {
		this.dao = dao;
	}
	
	public List<Books> getBook(){
		return dao.findAll();
	}
}
