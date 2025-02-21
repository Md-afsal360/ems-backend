package com.afsal.emc.emc_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.afsal.emc.emc_backend.dto.EmployeeDto;
import com.afsal.emc.emc_backend.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

	
	private EmployeeService employeeService;
	
	//build add employee rest api
	
	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
		EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
		return new ResponseEntity<>(employeeDto,HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEMployee(){
		List<EmployeeDto> employees = employeeService.gettAllEmployees();
		return new ResponseEntity<>(employees,HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,@RequestBody EmployeeDto updatedEmployee){
		EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedEmployee);
		return new ResponseEntity<>(employeeDto,HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
		employeeService.deleteEmployee(employeeId);
		
		return ResponseEntity.ok("EMPLOYEE DELETED SUCESSFULLY!");
	}
	
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	
	
	
}
