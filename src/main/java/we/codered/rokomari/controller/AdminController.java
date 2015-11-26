package we.codered.rokomari.controller;

import java.io.IOException;
import java.security.Principal;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import we.codered.rokomari.entity.User;
import we.codered.rokomari.service.UserService;

@Controller
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping({ "/profile", "/", "" })
	@ResponseBody
	public String profile(Principal principal){
		

		
		User user = userService.getUser(principal.getName());
		String value = null;
		ObjectMapper mapper = new ObjectMapper();
		
		try{
			value = mapper.writeValueAsString(user);	
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
		return value;
		
	}

}
