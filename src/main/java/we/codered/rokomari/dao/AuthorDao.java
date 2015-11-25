package we.codered.rokomari.dao;

import org.springframework.stereotype.Repository;

import we.codered.rokomari.entity.Authors;

@Repository("authorDao")
public class AuthorDao extends GenericHibernateDao<Authors>{

	public AuthorDao(){
		setClazz(Authors.class);
	}
}
