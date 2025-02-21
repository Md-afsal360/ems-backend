package com.afsal.emc.emc_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afsal.emc.emc_backend.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
  
}
