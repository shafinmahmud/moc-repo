package codered.rokomari.dao;

import org.springframework.stereotype.Repository;

import codered.rokomari.entity.Publishers;

@Repository("publishersDao")
public class PublisherDao extends GenericHibernateDao<Publishers> {

	public PublisherDao() {
		setClazz(Publishers.class);
	}
}
