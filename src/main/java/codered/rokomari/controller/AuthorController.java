package codered.rokomari.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

	@RequestMapping("/authors")
	public String authors(){
		
		return "authors";
		
	}
}
