package com.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.EmployeeDTO;
import com.service.EmployeeService;

@Controller
public class EmployeeController {
	//This is updated today
	
	
	@Autowired
	EmployeeService employeeService;
	
	
	@GetMapping({"/login","/"})
	public String callLoginPage() {
		
		
		return "login";
	}

	//registration operation
	
	@GetMapping("/register")
	public String callRegistrationPage() {		    
		return "employeeRegistration";
	}
	
	
	
	@PostMapping("/register")
	public String registerEmployee(@ModelAttribute EmployeeDTO employeeDTO, Model model) {		
		employeeService.registerEmp(employeeDTO);		
		model.addAttribute("message", "Registration completed successfully");
		return "employeeRegistration";
	}
	
	
	@PostMapping("/loginValidate")
	public String authenticate(@RequestParam String emailId,@RequestParam String password,Model model) {
		EmployeeDTO employeeDTO=employeeService.authenticate(emailId,password);	
		
		if(employeeDTO!=null) {
			     //not null case  ----> means true condition.---> means we have entered correct id & password
			model.addAttribute("employeeDTO",employeeDTO);
			return "congratulations";
		}else {
			// null case  ----> means false.---> means we have entered wrong  id & password  OR wrongId/password
			model.addAttribute("message","Wrong credential!!! Re-Try");
			return "login";
		}
	}
	
	//fetch all the records
	@GetMapping("/fetchAllRecords")
	public String showAllRecords(Model model) {
		List<EmployeeDTO> employeeDtoList=employeeService.findAllEmployees();		
		model.addAttribute("employeeDtoList",employeeDtoList);
		return "showAll";
	}
	
	
	//delete operation
	
	@GetMapping("/deleteEmployee")   //deleteEmployee
	public String deleteEmployee( @RequestParam int employeeId, Model model) {
		employeeService.deleteEmp(employeeId);			
		model.addAttribute("message", "Record deleted successfully");
		//return "info";
		return "redirect:/fetchAllRecords";
	}
	
	//edit operation
	//editEmployee
	
	//part-1
	@GetMapping("/editEmployee")
	public String editEmp(@RequestParam int employeeId,Model model) {
		EmployeeDTO employeeDTO=employeeService.retrieveRecord(employeeId);		
		model.addAttribute("employeeDTO",employeeDTO);   //5 data
		
		return "editEmployee";
	}
	
	//part-2
	//updateEmployee
	@PostMapping("/updateEmployee")
	public String updateEmp(@ModelAttribute EmployeeDTO employeeDTO,Model model) {
		employeeService.updateKaro(employeeDTO);		
		model.addAttribute("message","Record updated successfully");
		//return "info";		
		return "redirect:/fetchAllRecords";
	}
	
	//logout operation
	@GetMapping("logout")
	public String logoutEmployee(HttpSession session, Model model) {
		if(session!=null) {
			
			session.invalidate();  //destroy the session
		}		
		
		model.addAttribute("message","You have logged-out successfully");
		return "login";
	}
	
	
	
	
}
