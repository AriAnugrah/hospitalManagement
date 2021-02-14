package com.enigma.ari.tryThymeleaf.controllers;

import com.enigma.ari.tryThymeleaf.dao.PatientDao;
import com.enigma.ari.tryThymeleaf.entities.Patients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PatientController {
	
	@Autowired
	private PatientDao dao;
	
	@RequestMapping("/patient_table")
	public String viewHomePage(Model model) {
		List<Patients> listPatients = dao.list();
		model.addAttribute("listPatients", listPatients);
	    return "patient_table";
	}
	
	@RequestMapping("/new_patient")
	public String showNewForm(Model model) {
	    Patients patients = new Patients();
	    model.addAttribute("patients", patients);
	     
	    return "new_form_patient";
	}
	
	@RequestMapping(value = "/save_patient", method = RequestMethod.POST)
	public String save(@ModelAttribute("patients") Patients patients) {
	    dao.save(patients);
	     
	    return "redirect:/patient_table";
	}
	
	@RequestMapping("/edit_patient/{id}")
	public ModelAndView showEditForm(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("edit_form_patient");
	    Patients patients = dao.get(id);
	    mav.addObject("patients", patients);
	     
	    return mav;
	}
	
	@RequestMapping(value = "/update_patient", method = RequestMethod.POST)
	public String update(@ModelAttribute("patients") Patients patients) {
	    dao.update(patients);
	     
	    return "redirect:/patient_table";
	}
	
	@RequestMapping("/delete_patient/{id}")
	public String delete(@PathVariable(name = "id") int id) {
	    dao.delete(id);
	    return "redirect:/patient_table";
	}	
}
