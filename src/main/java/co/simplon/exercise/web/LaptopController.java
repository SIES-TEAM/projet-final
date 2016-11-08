package co.simplon.exercise.web;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
		model.addAttribute("laptops", laptopService.getAllLaptops());

		return new ModelAndView("laptops", model);
	}

	/**
	 * Display the laptopbyId
	 * 
	 * @return
	 */

	@RequestMapping("/laptopById")
	public ModelAndView getById(@RequestParam("id") Integer id, ModelMap model) {
		Laptop laptop = laptopService.findLaptopById(id);
		model.addAttribute("laptop", laptop);
		return new ModelAndView("laptop", model);
	}

	/**
	 * Display the form to add a laptop
	 * 
	 * @return
	 */

	@RequestMapping(value = "/formAdd", method = RequestMethod.GET)
	public ModelAndView getAddLaptopForm(ModelMap model) {

		return new ModelAndView("add-laptop", model);

	}

	@RequestMapping(path = "/add")
	public ModelAndView addLaptop(@RequestParam String name, @RequestParam String brand, ModelMap model) {
		laptopService.addOrUpdateLaptop(new Laptop(name, brand));

		return new ModelAndView("redirect:/laptops/formAdd");

	}

	/**
	 * Display the form to update a laptop
	 * 
	 * @return
	 */
	@RequestMapping(path = "/updateLaptop")
	public ModelAndView getUpdateLaptopForm(@RequestParam Integer id, ModelMap model) {

		Laptop lp = laptopService.findLaptopById(id);
		model.addAttribute(lp);

		return new ModelAndView("update-laptop", model);
	}

	@RequestMapping(path = "/update")
	public ModelAndView updateLaptop(@RequestParam Integer id, @RequestParam String name, @RequestParam String brand,
			ModelMap model) {

		Laptop lp = laptopService.findLaptopById(id);
		lp.setName(name);
		lp.setBrand(brand);
		laptopService.addOrUpdateLaptop(lp);
		return new ModelAndView("redirect:/laptops", model);

	}

	@RequestMapping(path = "/delete")
	public ModelAndView deleteLaptop(@RequestParam Integer id, ModelMap model) {
		laptopService.deleteLaptop(id);
		return new ModelAndView("redirect:/laptops");

	}
}
