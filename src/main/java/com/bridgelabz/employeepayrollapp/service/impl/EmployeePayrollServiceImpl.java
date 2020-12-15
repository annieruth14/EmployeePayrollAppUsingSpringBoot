package com.bridgelabz.employeepayrollapp.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.exception.BadRequestException;
import com.bridgelabz.employeepayrollapp.model.EmployeeDO;
import com.bridgelabz.employeepayrollapp.model.EmployeeEntity;
import com.bridgelabz.employeepayrollapp.model.ResponseDO;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;

import com.bridgelabz.employeepayrollapp.exception.NotFoundException;

@Service
public class EmployeePayrollServiceImpl implements IEmployeePayrollService{
	
	@Autowired
	private EmployeeRepository employeeRepository; 
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public ResponseDO addEmployee(EmployeeDO empDo) {
		if (empDo == null) {
			throw new BadRequestException("Name is not Proper");
		}
		EmployeeEntity empEntity = modelMapper.map(empDo, EmployeeEntity.class);
		empEntity = employeeRepository.save(empEntity);
		if(empEntity != null) {
			return new ResponseDO("successfully inserted !!!!");
		}
		else
			return new ResponseDO("not success");
	}
	
	@Override
	public List<EmployeeEntity> getEmployeeList() {
		List<EmployeeEntity> listOfEmployees = employeeRepository.findAll();
		if (listOfEmployees == null || listOfEmployees.isEmpty()) {
			throw new NotFoundException("No Data Found of any employee");
		}
		return listOfEmployees;
	}

	@Override
	public ResponseDO deleteEmployee(int id) {
		employeeRepository.deleteById(id);
		return new ResponseDO("Deleted successfully");
	}

	@Override
	public EmployeeDO findEmployee(int id) {
		EmployeeEntity employee = employeeRepository.findById(id);
		if(employee == null) {
			throw new NotFoundException("No Data Found for the id:" + id);
		}
		EmployeeDO employeeDo = modelMapper.map(employee, EmployeeDO.class);
		return employeeDo;
	}

	@Override
	public EmployeeDO updateEmployeeData(int empId, EmployeeDO empDo) {
		EmployeeEntity employee = employeeRepository.findById(empId);
		if(employee == null) {
			throw new NotFoundException("No Data Found for the id:" + empId);
		}
		modelMapper.map(empDo, employee);
		EmployeeEntity updatedEmployee = employeeRepository.save(employee);
		return modelMapper.map(updatedEmployee, EmployeeDO.class);
	} 
}
