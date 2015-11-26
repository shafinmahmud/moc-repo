package we.codered.rokomari.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import we.codered.rokomari.dao.UserDao;
import we.codered.rokomari.entity.User;

@Service("userService")
public class UserService {
	
	@Autowired
	UserDao userDao;

	public User getUser(String username){	
		return userDao.findByNamedQuery("User.findByUsername", "username", username);		
	}
}
