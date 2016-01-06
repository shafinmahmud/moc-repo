package codered.rokomari.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import codered.rokomari.beans.BookBean;
import codered.rokomari.dao.AuthorsDao;
import codered.rokomari.dao.BooksDao;
import codered.rokomari.dao.PublisherDao;
import codered.rokomari.entity.Books;

@Service("bookService")
public class BookService {

	@Autowired
	private BooksDao booksDao;

	@Autowired
	private AuthorsDao authorsDao;

	@Autowired
	private PublisherDao publisherDao;

	public boolean isExits(String isbn) {
		return booksDao.findByNamedQuery("Books.findByIsbn", "isbn", isbn) != null;
	}

	public BookBean getBookByTitle(String title) {

		Books book = booksDao.findByNamedQuery("Books.findByTitle", "title", title);
		if (book != null) {
			return entityToBean(book);
		} else {
			return null;
		}
	}

	public BookBean getBookByIsbn(String isbn) {
		if (isExits(isbn)) {
			return entityToBean(booksDao.findByNamedQuery("Books.findByIsbn", "isbn", isbn));
		} else {
			return null;
		}
	}

	public List<BookBean> getAllBooks() {
		Iterator<Books> listIter = booksDao.findAll().iterator();
		List<BookBean> books = new ArrayList<BookBean>();
		while (listIter.hasNext()) {
			books.add(entityToBean(listIter.next()));
		}
		return books;
	}

	public void saveBook(BookBean book) {
		booksDao.create(beanToEntity(book));
	}

	public void updateBook(BookBean book) {
		booksDao.update(beanToEntity(book));
	}

	public void deleteBook(String isbn) {
		booksDao.delete(booksDao.findByNamedQuery("Books.findByIsbn", "isbn", isbn));
	}

	public void deleteAllBook() {
		System.out.println("currently i m not gonna delete all data. sorry.");
	}

	private BookBean entityToBean(Books books) {
		return new BookBean(books.getTitle(), books.getAuthorIdFk().getAuthorName(), books.getIsbn(),
				books.getPublisherIdFk().getPublisherName());
	}

	private Books beanToEntity(BookBean bean) {
		Books books = new Books();
		books.setTitle(bean.getTitle());
		books.setAuthorIdFk(authorsDao.findByNamedQuery("Authors.findByAuthorName", "authorName", bean.getAuthor()));
		books.setPublisherIdFk(
				publisherDao.findByNamedQuery("Publishers.findByPublisherName", "publisherName", bean.getPublisher()));
		books.setIsbn(bean.getIsbn());
		books.setCreatedAt(new Date());
		return books;
	}
}
