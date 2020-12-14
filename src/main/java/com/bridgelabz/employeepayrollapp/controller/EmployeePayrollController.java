package com.bridgelabz.employeepayrollapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayrollapp.model.EmployeeDO;
import com.bridgelabz.employeepayrollapp.model.ResponseDO;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;

@Controller
public class EmployeePayrollController {
	
	@Autowired
	private IEmployeePayrollService employeePayrollService;
	
//	@RequestMapping(value = {"/get"})
//	public ResponseEntity<ResponseDO> getEmployeePayrollData() {
//		return new ResponseEntity<ResponseDO>(employeePayrollService.getEmployeeList(), HttpStatus.OK);
//	}
	
	@PostMapping(value = {"/add"})
	public ResponseEntity<ResponseDO> addEmployee(@RequestBody EmployeeDO empDo) {
		return new ResponseEntity<ResponseDO>(employeePayrollService.addEmployee(empDo), HttpStatus.OK);
	}
	
	@GetMapping(value = {"/list"})
	public ResponseEntity<List<EmployeeDO>> getEmployeeList() {
		return new ResponseEntity<List<EmployeeDO>>(employeePayrollService.getEmployeeList() , HttpStatus.OK) ;
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ResponseDO> deleteEmployee(@PathVariable int id) {
		return new ResponseEntity<ResponseDO>(employeePayrollService.deleteEmployee(id) , HttpStatus.OK);
	}
	
	@GetMapping(value = "/find{id}")
	public ResponseEntity<EmployeeDO> findEmployeeById(@PathVariable int id) {
		return new ResponseEntity<EmployeeDO>(employeePayrollService.findEmployee(id), HttpStatus.OK);
	}
	
	@PutMapping(value = "/update{id}")
	public ResponseEntity<EmployeeDO> updateEmployee(@RequestBody EmployeeDO empDo, @PathVariable int id) {
		return new ResponseEntity<EmployeeDO>(employeePayrollService.updateEmployeeData(id, empDo) , HttpStatus.OK);
	}
}
