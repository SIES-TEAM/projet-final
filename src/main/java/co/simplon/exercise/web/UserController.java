package co.simplon.exercise.web;

import java.util.List;

import co.simplon.exercise.core.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import co.simplon.exercise.core.service.UserService;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(path = "/profil")
	public ModelAndView getMyProfil(ModelMap model) {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User myself = userService.findOneByEmail(email);
		model.addAttribute("myInfos", myself);
		return new ModelAndView("user/myprofil", model);
	}

	@RequestMapping(path = "/form/add/account")
	public ModelAndView getCreateAccountForm(){
		return new ModelAndView("user/create-account");
	}

	@RequestMapping(path = "/account/create")
	public ModelAndView addUser(  @RequestParam String name,
								  @RequestParam String surname,
								  @RequestParam String email,
								  @RequestParam String password,
								  ModelMap model) {
		String role = "USER";
		userService.addOrUpdate(new User(name, surname, password, email, role));
		return new ModelAndView("redirect:/");
	}

	/**
	 * get a form to update a user by id
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(path="/updateUserForm")
	public ModelAndView getUpdateForm(@RequestParam Integer id, ModelMap model)
	{
		User ps = userService.findById(id);
		model.addAttribute(ps);

		return new ModelAndView("user/updateUserForm", model);
	}

	@RequestMapping(path="/update")
	public ModelAndView updateUser(@RequestParam Integer id,
								   @RequestParam String name,
								   @RequestParam String surname,
								   @RequestParam String password,
								   @RequestParam String email,
								   ModelMap model)
	{
		User userToUpdate = userService.findById(id);
		modifyUser(name, surname, password, email, userToUpdate);

		return new ModelAndView("redirect:/users", model);
	}

	private void modifyUser(@RequestParam String name, @RequestParam String surname, @RequestParam String password, @RequestParam String email, User userToUpdate) {
		userToUpdate.setName(name);
		userToUpdate.setSurname(surname);
		userToUpdate.setPassword(password);
		userToUpdate.setEmail(email);
		userService.addOrUpdate(userToUpdate);
	}

}
