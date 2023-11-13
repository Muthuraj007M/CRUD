package com.example.SpringThymeleafCRUD.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SpringThymeleafCRUD.Entity.Employee;
import com.example.SpringThymeleafCRUD.Service.EmployeeServiceImpl;

@Controller
@RequestMapping("/crud")
public class EmployeeController {

	EmployeeServiceImpl esl;

	@Autowired
	public EmployeeController(EmployeeServiceImpl esl) {
		super();
		this.esl = esl;
	}

	@GetMapping("/employees")
	public String findAllEmployees(Model theModel) {
		List<Employee> emplist = esl.findAll();
		theModel.addAttribute("list", emplist);
		return "EmployeeDirectory";
	}

	@GetMapping("/showformtoadd")
	public String addEmployee(Model theModel) {
		Employee e = new Employee();
		theModel.addAttribute("employee", e);
		return "empform";
	}

	@GetMapping("/showformtoupdate")
	public String updateEmployee(@RequestParam("employeeid") int id, Model theModel) {
		Employee emp = esl.findById(id);
		theModel.addAttribute("employee", emp);
		return "empform";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("employeeid") int id, Model theModel) {
		esl.delete(id);
		return "redirect:/crud/employees";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("employee") Employee e) {
		esl.save(e);
		return "redirect:/crud/employees";
	}
}
