package we.codered.rokomari.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import we.codered.rokomari.dao.AuthorsDao;

@Service("authorService")
public class AuthorService {

	@Autowired 
	private AuthorsDao authorsDao;

	public boolean isExits(String authorName){
		return authorsDao.findByNamedQuery("Authors.finadByAuthorName", "authorName", authorName) != null;
	}

}
