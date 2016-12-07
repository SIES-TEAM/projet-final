package co.simplon.exercise.web;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.simplon.exercise.core.model.Classroom;
import co.simplon.exercise.core.model.Laptop;

import co.simplon.exercise.core.service.LaptopService;

@Controller
@RequestMapping("/laptops")
public class LaptopController {
	@Autowired
	LaptopService laptopService;

	/**
	 * Display all laptops
	 * 
	 * @return
	 */
	@RequestMapping
	public ModelAndView showLaptops(ModelMap model) {
		model.addAttribute("laptops", laptopService.getAll());

		return new ModelAndView("laptop/laptops", model);
	}


	/**
	 * Display the form to add a laptop
	 * 
	 * @return
	 */

	@RequestMapping(value = "/formAdd", method = RequestMethod.GET)
	public ModelAndView getAddLaptopForm(ModelMap model) {

		return new ModelAndView("laptop/add-laptop", model);
	}

	@RequestMapping(path = "/add")
	public ModelAndView addLaptop(@RequestParam String name, 
								@RequestParam String brand, 
								ModelMap model) {
		laptopService.addOrUpdate(new Laptop(name, brand));

		return new ModelAndView("redirect:/laptops/formAdd");

	}

	/**
	 * Display the form to update a laptop
	 * 
	 * @return
	 */
	@RequestMapping(path = "/updateLaptop")
	public ModelAndView getUpdateLaptopForm(@RequestParam Integer id, ModelMap model) {
		Laptop lp = laptopService.findById(id);
		model.addAttribute(lp);
		return new ModelAndView("update-laptop", model);
	}

	@RequestMapping(path = "/update")
	public ModelAndView updateLaptop(@RequestParam Integer id,
									 @RequestParam String name,
									 @RequestParam String brand,
									 ModelMap model) {
		Laptop lp = laptopService.findById(id);
		lp.setName(name);
		lp.setBrand(brand);
		laptopService.addOrUpdate(lp);
		return new ModelAndView("redirect:/laptops", model);

	}
	
	/**
	 * Delete laptop
	 * 
	 * @return
	 */
	@RequestMapping(path = "/delete")
	public ModelAndView delete(@RequestParam Integer id, ModelMap model) {

		laptopService.delete(id);
		return new ModelAndView("redirect:/laptops");

	}
}
