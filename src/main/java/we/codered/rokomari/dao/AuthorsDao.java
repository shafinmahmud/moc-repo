package we.codered.rokomari.dao;

import org.springframework.stereotype.Repository;

import we.codered.rokomari.entity.Authors;

@Repository("authorsDao")
public class AuthorsDao extends GenericHibernateDao<Authors>{

	public AuthorsDao(){
		setClazz(Authors.class);
	}
}
