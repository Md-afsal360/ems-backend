package com.afsal.emc.emc_backend.service;

import java.util.List;

import com.afsal.emc.emc_backend.dto.EmployeeDto;


public interface EmployeeService {

	EmployeeDto createEmployee(EmployeeDto employeeDto);
	
	EmployeeDto getEmployeeById(Long employeeId);
	
	List<EmployeeDto> gettAllEmployees();
	
	EmployeeDto updateEmployee(Long employeeId,EmployeeDto updateEmployee);
	
	void deleteEmployee(Long employeeId);
}
