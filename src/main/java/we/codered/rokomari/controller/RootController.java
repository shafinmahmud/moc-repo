package we.codered.rokomari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import we.codered.rokomari.entity.Books;
import we.codered.rokomari.service.BookService;

@Controller
public class RootController {
	
	@Autowired
	private BookService testService; // just service layer test korar jonno.. apatoto thak
	
	@RequestMapping("/")
	public String home(){
		List<Books> books = testService.getBook();
		for(Books b : books){
			System.out.println(b.getTitle() + " by: "+b.getAuthorIdFk().getAuthorName());
		}
		return "home";
		
	}

}
