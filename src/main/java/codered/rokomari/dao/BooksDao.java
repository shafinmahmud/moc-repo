package codered.rokomari.dao;

import org.springframework.stereotype.Repository;

import codered.rokomari.entity.Books;

@Repository("booksDao")
public class BooksDao extends GenericHibernateDao<Books>{

	public BooksDao(){
		setClazz(Books.class);
	}
}
