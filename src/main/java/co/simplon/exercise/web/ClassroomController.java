package co.simplon.exercise.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.simplon.exercise.core.model.Classroom;
import co.simplon.exercise.core.service.ClassroomService;


@Controller
@RequestMapping("/classroom")
public class ClassroomController {
	
	@Autowired
	private ClassroomService classroomService;

	// Constructors


	public ClassroomController( ClassroomService classroomService) {

		this.classroomService = classroomService;
	}

	public ClassroomController() {
	}

	@RequestMapping
	public ModelAndView get( ModelMap model) {
		List<Classroom> classrooms = classroomService.getAll();
		model.addAttribute("classrooms", classrooms);
		return new ModelAndView("room/classrooms", model);
	}


 @RequestMapping(value = "/formAdd", method = RequestMethod.GET)
	public ModelAndView classroomForm(ModelMap model) {
		return new ModelAndView("room/add-classroom", model);
	   }
	
 
	@RequestMapping("/add")
	public ModelAndView add(@RequestParam int capacity,@RequestParam String name, ModelMap model)
	{
		classroomService.addOrUpdate(new Classroom(name, capacity));
		return new ModelAndView("redirect:/classroom/formAdd");
	}
	

	@RequestMapping("/delete")
	public ModelAndView remove(@RequestParam Integer id, ModelMap model) {
		
		classroomService.delete(id);
		return new ModelAndView("redirect:/classroom");
	}
	
	
	
	@RequestMapping(path="/updateClassroom")
	public ModelAndView getUpdateClassroomForm(@RequestParam Integer id, ModelMap model)
	{
		Classroom cl = classroomService.findById(id);
		model.addAttribute(cl);
		
		return new ModelAndView("room/updateClassroomForm", model);
	}
	
	@RequestMapping(path="/update")
	public ModelAndView updateClassroom(Integer id, String name, int capacity, ModelMap model)
	{
		Classroom cl = classroomService.findById(id);
		cl.setName(name);
		cl.setCapacity(capacity);
		classroomService.addOrUpdate(cl);
		return new ModelAndView("redirect:/classroom", model);
		
	}
	
	
	
	
	
	
	
}
