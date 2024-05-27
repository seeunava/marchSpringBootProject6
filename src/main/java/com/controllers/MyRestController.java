package com.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dto.EmployeeDTO;
import com.service.EmployeeService;

@RestController

public class MyRestController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees")
	
	List<EmployeeDTO> findAllEmployees(){
		
	EmployeeDTO emp1= new EmployeeDTO(1,"Nava",23456,"nd@gmail.com","1234");
	EmployeeDTO emp2= new EmployeeDTO(2,"Shiva",3456,"ss@gmail.com","1234");
	EmployeeDTO emp3= new EmployeeDTO(3, "Malya", 1220,"malya@gmail.com", "1234");
	List<EmployeeDTO> list = new ArrayList<>();
	
	list.add(emp1);
	list.add(emp2);
	list.add(emp3);
	
	return list;
	
	
	//List<EmployeeDTO> employeeDtoList=employeeservice.findAllEmployeesByName();

}
	
	@PostMapping("/employees")
    public String registerEmployee(@RequestBody EmployeeDTO employeeDTO, Model model) {
        employeeService.registerEmp(employeeDTO);
        return "Registration completed successfully";
    }
 
 //http://localhost:1996/employees/10
 
      @GetMapping("/employees/{employeeId}")
 
 EmployeeDTO findEmployee(@PathVariable int employeeId){
       EmployeeDTO employeeDTO =employeeService.findEmployeeById(employeeId);
       
       
  return employeeDTO;
       
       
      }
      
      @PutMapping("/employees/{employeesId}")
      public String updateEmployee(@PathVariable int employeeId,@RequestBody EmployeeDTO employeeDTO) {
    
    	  employeeService.registerEmp(employeeDTO);
    	  return "updated successfully";
	}
      
      @PutMapping("/employees/{employeeId}")
      
      public String updateEmployee1(@PathVariable int employeeId,@RequestBody EmployeeDTO employeeDTO) {
    	  employeeDTO.setEmployeeId(employeeId);
    	  employeeService.registerEmp(employeeDTO);
    	  return "updated successfully";
    	  
      }
      
      
      
      
      
      
      
}
