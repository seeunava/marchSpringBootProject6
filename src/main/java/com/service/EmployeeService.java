package com.service;

import java.util.List;

import com.dto.EmployeeDTO;

public interface EmployeeService {

	void registerEmp(EmployeeDTO employeeDTO);

	EmployeeDTO authenticate(String emailId, String password);

	List<EmployeeDTO> findAllEmployees();

	void deleteEmp(int employeeId);

	EmployeeDTO retrieveRecord(int employeeId);

	void updateKaro(EmployeeDTO employeeDTO);

	EmployeeDTO findEmployeeById(int employeeId);

	List<EmployeeDTO> findAllEmployeesSortedByName();

}
