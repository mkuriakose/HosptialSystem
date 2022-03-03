package com.example.Hospital.controller;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.Hospital.model.Nurse;
import com.example.Hospital.service.NurseService;

@Controller
@RequestMapping("/nurse")
public class NurselController {
	@Autowired
	private NurseService nuseService;
	
	@GetMapping("/")
	public String viewNurseList(Model model) {
		List<Nurse> nurseList = nuseService.listAll();
		System.out.println("size of nurseList " + nurseList.size());
		model.addAttribute(nurseList);
		return "nurseList";
	}
	
	@RequestMapping("/new")
	public String showNurseForm(Model model) {
		Nurse nurse = new Nurse();
		model.addAttribute("nurse", nurse);
		return "createNurse";
		
	}
	
	@PostMapping("/save")
	public String saveNurse(@ModelAttribute Nurse nurse ) {
		nuseService.save(nurse);
		System.out.println("Nurse data Saved");
		return "redirect:/nurse/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView saveNurse(@PathVariable(name="id")Long id) {
		ModelAndView modeAndView = new ModelAndView("editNurse");
		Nurse nurse = nuseService.get(id);
		modeAndView.addObject(nurse);
		System.out.println("Nurse data Saved");
		return modeAndView;
	}

}
