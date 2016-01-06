package codered.rokomari.dao;

import org.springframework.stereotype.Repository;

import codered.rokomari.entity.Authors;

@Repository("authorsDao")
public class AuthorsDao extends GenericHibernateDao<Authors>{

	public AuthorsDao(){
		setClazz(Authors.class);
	}
}
