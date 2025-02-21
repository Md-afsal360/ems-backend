package com.afsal.emc.emc_backend.mapper;

import com.afsal.emc.emc_backend.dto.EmployeeDto;
import com.afsal.emc.emc_backend.entity.Employee;

public class EmployeeMapper {

	
	public static EmployeeDto maptoEmployeeDto(Employee employee) {
		return new EmployeeDto(
				employee.getId(),
				employee.getName(),
				employee.getEmail(),
				employee.getPosition(),
				employee.getSalary(),
				employee.getPhone()
				);
	}
	
	public static Employee maptoEmployee(EmployeeDto employeeDto) {
		
		return new Employee(
				employeeDto.getId(),
				employeeDto.getName(),
				employeeDto.getEmail(),
				employeeDto.getPosition(),
				employeeDto.getPhone(),
				employeeDto.getSalary()
				);
	}
}
