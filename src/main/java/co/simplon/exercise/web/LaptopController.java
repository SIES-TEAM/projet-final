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
@RequestMapping("/laptop")
public class LaptopController {
	@Autowired
	LaptopService laptopService;

	@RequestMapping
	public ModelAndView showLaptops(ModelMap model) {
		model.addAttribute("laptop", laptopService.getAll());

		return new ModelAndView("laptop", model);
	}

	/**
	 * Display the form to add a laptop
	 * 
	 * @return
	 */
	@RequestMapping(value = "/formAdd", method = RequestMethod.GET)
	public ModelAndView getAddLaptopForm(ModelMap model) {

		// model.addAttribute("message", "Hello");
		return new ModelAndView("laptop/add-laptop", model);

	}

	@RequestMapping(path = "/add")
	public ModelAndView addLaptop(
			                      @RequestParam String name,
			                      @RequestParam String brand,
			                      ModelMap model
			                      ) {
		// if(result.hasError)
		laptopService.addOrUpdate(new Laptop(name, brand));

		// redirectAttribute.addFlashAttribute("success", "Ordinateur réservé
		// avec succès !");
		return new ModelAndView("redirect:/laptop/formAdd");

	}

	@RequestMapping(path = "/delete")
	public ModelAndView  deleteLaptop(@RequestParam Integer id, 
									  ModelMap model
									){
		laptopService.delete(id);
		return new ModelAndView("redirect:/laptop");
		
	}
}
