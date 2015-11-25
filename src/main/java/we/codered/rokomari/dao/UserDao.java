package we.codered.rokomari.dao;

import org.hibernate.Query;

import we.codered.rokomari.entity.User;

public class UserDao extends GenericHibernateDao<User>  {
	
	public UserDao() {
		setClazz(User.class);
	}
    
	public User getUserByEmail(String email){
		
		Query query =  getCurrentSession().createQuery("from User where email =:email");
		
		query.setParameter("email", email);
		
		return (User)query.uniqueResult();
	}

}
