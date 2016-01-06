package codered.rokomari.dao;

import org.springframework.stereotype.Repository;

import codered.rokomari.entity.User;

@Repository("userDao")
public class UserDao extends GenericHibernateDao<User>  {
	
	public UserDao() {
		setClazz(User.class);
	}
}
