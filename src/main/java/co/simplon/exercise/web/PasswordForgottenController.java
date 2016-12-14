package co.simplon.exercise.web;

import java.security.SecureRandom;
import java.util.Date;

import co.simplon.exercise.core.service.mailing.EmailAPI;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import co.simplon.exercise.core.model.Mail;
import co.simplon.exercise.core.model.User;
import co.simplon.exercise.core.service.MailService;
import co.simplon.exercise.core.service.UserService;

@Controller
public class PasswordForgottenController {

	@Autowired
    private MailService mailService;
	@Autowired
	private UserService userService;
	
	@Autowired
	EmailAPI emailAPI;

	/**
	 *  Generer le mot de passe
	 * @return
	 */
	private String generateMP() {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
		String pwd = RandomStringUtils.random(15, 0, 0, false, false, characters.toCharArray(), new SecureRandom());
		return pwd;
	}
	
	/**
	 * Envoyer le mot de pass cripter par mail
	 * @param pwd
	 * @param email
	 */
	private void sendMpEmail(String pwd, String email, String msgBody, String subject ) {
		// TODO
			msgBody= "Votre nouveau mdp est: " + pwd;
			subject = "Récuperation du mot de passe";
			String toAdress= email;
			String actualFromAdress = "simplon.company@gmail.com";
	        Date createdAt = new Date();
	        Mail mail = new Mail(email,createdAt, 0, null, subject, msgBody);
	        //enregistrer ds la base
	        mailService.addOrUpdate(mail);
	        //envoi mail
	        emailAPI.sendEmail(toAdress,actualFromAdress, subject, msgBody);
		}
	

	/**
	 * Methode pour l'affichage du formulaire de l'oubli du mot de passe
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/sendMPmailForm", method = RequestMethod.GET)
	public ModelAndView getpassWordForm(ModelMap model) {
		return new ModelAndView("/authentication/mailpwforgotten", model);
	}

	/**
	 * Traite le formulaire web d'oubli de mot de passe
	 * @param email email de l'utilisateur ayant oublié le mot de passe
	 * @return
	 * 
	 */
	@RequestMapping(value = "/sendMP", method = RequestMethod.GET)
	public ModelAndView sendPassword(String email) {
		
		String pwd = generateMP();
		String msgBody= "Votre nouveau mdp est: " + pwd;
		String subject = "Récuperation du mot de passe";
		User user = userService.findOneByEmail(email);
		//envoi du mail
		 sendMpEmail(pwd, email, msgBody, subject); 
		user.setPassword(pwd);
		//System.out.println(pwd);
		//ajout de MP dans la bade de donnée
		userService.addOrUpdate(user);
		//affichage d'un message de validation d'envoi du MP
		return new ModelAndView("/authentication/msgChangeMP");
		
	}

}
