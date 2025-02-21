package com.afsal.emc.emc_backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afsal.emc.emc_backend.dto.EmployeeDto;
import com.afsal.emc.emc_backend.entity.Employee;
import com.afsal.emc.emc_backend.exeption.ResourceNotFoundExeption;
import com.afsal.emc.emc_backend.mapper.EmployeeMapper;
import com.afsal.emc.emc_backend.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	
	private EmployeeRepository employeeRepo;
	
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		Employee employee = EmployeeMapper.maptoEmployee(employeeDto);
		
		Employee createEmployee = employeeRepo.save(employee);
		return EmployeeMapper.maptoEmployeeDto(createEmployee);
	}


	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepo.findById(employeeId)
				.orElseThrow(()-> new ResourceNotFoundExeption("Employee is not there" + employeeId));
		return EmployeeMapper.maptoEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> gettAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> employees = employeeRepo.findAll();
		
		return employees.stream().map((employee) -> EmployeeMapper.maptoEmployeeDto(employee)).collect(Collectors.toList());
	}


	public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}


	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepo.findById(employeeId).orElseThrow(()-> new ResourceNotFoundExeption("Employee is not exist with given Id" + employeeId));
		
		employee.setName(updateEmployee.getName());
		employee.setEmail(updateEmployee.getEmail());
		employee.setPosition(updateEmployee.getPosition());
		employee.setPhone(updateEmployee.getPhone());
		employee.setSalary(updateEmployee.getSalary());
		
		Employee updatedEmployee= employeeRepo.save(employee);
		
		return EmployeeMapper.maptoEmployeeDto(updatedEmployee);
	}


	@Override
	public void deleteEmployee(Long employeeId) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepo.findById(employeeId).orElseThrow(()-> new ResourceNotFoundExeption("Employee is not exist with given Id" + employeeId));
		
		employeeRepo.deleteById(employeeId);
	}
	
	

	
	
}
