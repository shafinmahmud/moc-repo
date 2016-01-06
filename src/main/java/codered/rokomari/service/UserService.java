package codered.rokomari.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import codered.rokomari.dao.UserDao;
import codered.rokomari.entity.User;

@Service("userService")
public class UserService {
	
	@Autowired
	UserDao userDao;

	public User getUser(String username){	
		return userDao.findByNamedQuery("User.findByUsername", "username", username);		
	}

}
