package com.bridgelabz.employeepayrollapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.employeepayrollapp.model.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>{
	
	public EmployeeEntity findById(int id);
}
