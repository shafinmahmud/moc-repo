package we.codered.rokomari.dao;

import org.springframework.stereotype.Repository;

import we.codered.rokomari.entity.Books;

@Repository
public class BooksDao extends AbstractHibernateDao<Books>{

	public BooksDao(){
		setClazz(Books.class);
	}
}
