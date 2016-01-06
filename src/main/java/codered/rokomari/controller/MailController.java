package codered.rokomari.controller;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import codered.rokomari.service.UserService;

@Controller
@RequestMapping("mail")
public class MailController {

	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	UserService userService;

	

	
	@ResponseBody
	@RequestMapping(value = "recoveryemail", method = RequestMethod.POST)
	public String emailSend(String emailAddress) {
        
		System.out.println(emailAddress);

		final String email = emailAddress;

		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {

				MimeMessageHelper messageHelper = new MimeMessageHelper(
						mimeMessage, true, "UTF-8");

				messageHelper.setFrom("sunnycse250@gmail.com");
				messageHelper.setTo(email);
				messageHelper.setSubject("Your new password");
				messageHelper.setText("Hello sir your password is given");

			}
		};

		try {

			mailSender.send(preparator);
			System.out.println("sending email");
			return "ok";

		} catch (MailException e) {

			e.printStackTrace();
			return "error";

		}

	}

}
