package com.bridgelabz.employeepayrollapp.controller;

import java.util.List;

import javax.validation.Valid;

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
import com.bridgelabz.employeepayrollapp.model.EmployeeEntity;
import com.bridgelabz.employeepayrollapp.model.ResponseDO;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;

@Controller
public class EmployeePayrollController {
	
	@Autowired
	private IEmployeePayrollService employeePayrollService;
	
	/**
	 * This api is used to add new Employee to database.
	 * @param empDo
	 * @return ResponseEntity
	 */
	@PostMapping(value = {"/add"})
	public ResponseEntity<ResponseDO> addEmployee(@RequestBody @Valid EmployeeDO empDo) {
		return new ResponseEntity<ResponseDO>(employeePayrollService.addEmployee(empDo), HttpStatus.OK);
	}
	
	/**
	 * This api is used to get the list of employees from database.
	 * @param 
	 * @return ResponseEntity
	 */
	@GetMapping(value = {"/list"})
	public ResponseEntity<List<EmployeeEntity>> getEmployeeList() {
		return new ResponseEntity<List<EmployeeEntity>>(employeePayrollService.getEmployeeList() , HttpStatus.OK) ;
	}
	
	/**
	 * This api is used to delete an employee from database.
	 * @param id
	 * @return ResponseEntity
	 */
	@DeleteMapping(value = "/delete{id}")
	public ResponseEntity<ResponseDO> deleteEmployee(@PathVariable int id) {
		return new ResponseEntity<ResponseDO>(employeePayrollService.deleteEmployee(id) , HttpStatus.OK);
	}
	
	/**
	 * This api is used to find an employee from database.
	 * @param id
	 * @return ResponseEntity
	 */
	@GetMapping(value = "/find{id}")
	public ResponseEntity<EmployeeDO> findEmployeeById(@PathVariable int id) {
		return new ResponseEntity<EmployeeDO>(employeePayrollService.findEmployee(id), HttpStatus.OK);
	}
	
	/**
	 * This api is used to update an employee.
	 * @param empDo
	 * @param id
	 * @return ResponseEntity
	 */
	@PutMapping(value = "/update{id}")
	public ResponseEntity<EmployeeDO> updateEmployee(@RequestBody EmployeeDO empDo, @PathVariable int id) {
		return new ResponseEntity<EmployeeDO>(employeePayrollService.updateEmployeeData(id, empDo) , HttpStatus.OK);
	}
}
