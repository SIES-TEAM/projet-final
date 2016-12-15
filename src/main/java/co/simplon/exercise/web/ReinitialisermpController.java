package co.simplon.exercise.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;import co.simplon.exercise.core.model.User;
import co.simplon.exercise.core.service.UserService;
import co.simplon.exercise.core.service.mailing.EmailAPI;

@Controller
public class ReinitialisermpController {
	
	@Autowired
	private UserService userService;

	@Autowired
    EmailAPI emailAPI;

	/**
	 * Methode pour l'affichage du formulaire due la réinitialisation du mot de passe 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/renitialmpForm", method = RequestMethod.GET)
	public ModelAndView getpassWordForm(ModelMap model) {
		return new ModelAndView("/authentication/reinitialiserMP", model);
	}
	
	/**
	 * Récuperer ancien email, tester s'il est la meme qui exsiste dans la base
	 * * tester si le nouvelle mot de passse est la meme que celle qui été validet
	 * Sauvegarder la nouvelle mot de passe dans la base 
	 * 
	 * 
	 */
	
	@RequestMapping(value = "/sendNouveauMP", method = RequestMethod.GET)
	public ModelAndView cahngepasssW(String newPassword, String newPasswordControl, ModelMap model ) {
		String email= SecurityContextHolder.getContext().getAuthentication().getName();

		if( newPassword.equals(newPasswordControl))
		{
		    User user = userService.findOneByEmail(email);
		    user.setPassword(newPassword);
		    userService.addOrUpdate(user);
		}
		return new ModelAndView("/home", model);
	}
}
