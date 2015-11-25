package we.codered.rokomari.dao;

import org.springframework.stereotype.Repository;

import we.codered.rokomari.entity.Books;

@Repository("bookDao")
public class BooksDao extends GenericHibernateDao<Books>{

	public BooksDao(){
		setClazz(Books.class);
	}
}
