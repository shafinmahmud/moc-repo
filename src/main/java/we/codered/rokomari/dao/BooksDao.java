package we.codered.rokomari.dao;

import org.springframework.stereotype.Repository;

import we.codered.rokomari.entity.Books;

@Repository
public class BooksDao extends AbstractHibernateDao<Books>{

	public BooksDao(){
		System.out.println("this is now from the dao layer");
		setClazz(Books.class);
	}
}
