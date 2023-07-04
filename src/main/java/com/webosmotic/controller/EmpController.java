package com.webosmotic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webosmotic.controller.dao.EmpDao;
import com.webosmotic.controller.modal.Employee;

@Controller
public class EmpController {
	@Autowired
	EmpDao dao;
	
	@RequestMapping("/empform")
	public String showForm(Model model) {
		model.addAttribute("command", new Employee());
		return "empform";
		
	}
	
	
	@PostMapping("/save")
	public String save (Employee emp) {
		dao.save(emp);
		return "redirect:/viewemp";
	}
	
	@GetMapping("/empedit/{id}")
	public String viewemp(@PathVariable int id,  Model modal) {
		List<Employee>list=(List<Employee>) dao.getEmpById(id);
		modal.addAttribute("command", list);
		return "empeditform";
	}
	
	@PutMapping("/editsave")
	public String editsave(Employee emp) {
		dao.update(emp);
		return "redirect:/viewemp";
	}
	
	
	@DeleteMapping("/deleteemp/{id}")
	public String deleteemp(@PathVariable int id) {
		dao.delete(id);
		return "redirect:/viewemp";
	}
	
	

}
