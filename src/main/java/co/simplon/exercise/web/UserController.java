package co.simplon.exercise.web;

import java.util.List;

import co.simplon.exercise.core.model.User;
import org.springframework.beans.factory.annotation.Autowired;
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

	@RequestMapping()
	public ModelAndView get(ModelMap model) {
		List<User> user = userService.getAll();
		//System.out.println(user);
		model.addAttribute("users", user);
		return new ModelAndView("user/usersList", model);
	}

	@RequestMapping(path = "/formAdd")
	public ModelAndView getUserAddForm(){
		return new ModelAndView("user/addUserForm");
	}

	@RequestMapping(path = "/addUser")
	public ModelAndView addUser(@RequestParam String name,
								  @RequestParam String surname,
								  @RequestParam String email,
								  @RequestParam String password,
								  @RequestParam String role,
								  ModelMap model) {
		userService.addOrUpdate(new User(name, surname, password, email, role));
		return new ModelAndView("redirect:/users");
	}

	/**
	 * get a form to update a user by id
	 * @param id
	 * @param model
	 * @return
	 */
//	@RequestMapping(path="/updateUserForm")
//	public ModelAndView getUpdateForm(@RequestParam Integer id, ModelMap model)
//	{
//		User ps = userService.findById(id);
//		model.addAttribute(ps);
//
//		return new ModelAndView("updateUserForm", model);
//	}
//
//	@RequestMapping(path="/update")
//	public ModelAndView updateUser(@RequestParam Integer id,
//								   @RequestParam String name,
//								   @RequestParam String surname,
//									 String password,
//									 String email,
//									 ModelMap model)
//	{
//		User userToUpdate = userService.findById(id);
//		userToUpdate.setName(name);
//		userToUpdate.setSurname(surname);
//		userToUpdate.setPassword(password);
//		userToUpdate.setEmail(email);
//		userService.addOrUpdate(userToUpdate);
//
//		return new ModelAndView("redirect:/person", model);
//	}

//	@RequestMapping(path = "/delete")
//	public ModelAndView deleteUser(Integer id)
//	{
//
//
//	}

}
