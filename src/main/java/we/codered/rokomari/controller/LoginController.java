package we.codered.rokomari.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import we.codered.rokomari.beans.SignUpBean;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String showLogin() {

		return "login";
	}
	
	@RequestMapping("/signup")
	public String showSignUp(Model model,@Valid SignUpBean signUpBean,
			BindingResult result){
       
		model.addAttribute(new SignUpBean());
		return "signup";
	}
	
	@RequestMapping("/createaccount")
	public String signUpSubmit(Model model,@Valid SignUpBean signUpBean,
			BindingResult result,HttpServletResponse response)  {
		
		System.out.println(signUpBean);
		
		if(result.hasErrors()){
			
			return "signup";
		}

		
		return null;
		
		
	}
}
