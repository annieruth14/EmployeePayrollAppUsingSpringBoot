package com.bridgelabz.employeepayrollapp.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
	
	@Override
	public ResponseDO addEmployee(EmployeeDO empDo) {
		if (empDo == null) {
			throw new BadRequestException("Name is not Proper");
		}
		EmployeeEntity empEntity = new EmployeeEntity();
		empEntity = this.convertEntity(empEntity, empDo);
		empEntity = employeeRepository.save(empEntity);
		if(empEntity != null) {
			return new ResponseDO("successfully inserted !!!!");
		}
		else
			return new ResponseDO("not success");
	}
	
	@Override
	public List<EmployeeDO> getEmployeeList() {
		List<EmployeeEntity> listOfEmployees = new ArrayList<>();
		listOfEmployees = employeeRepository.findAll();
		if (listOfEmployees == null || listOfEmployees.isEmpty()) {
			throw new NotFoundException("No Data Found of any employee");
		}
		return listOfEmployees.stream().map(employee -> {
			EmployeeDO employeeDo = convertObj(employee);
			return employeeDo;
		}).collect(Collectors.toList());
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
		EmployeeDO employeeDo = convertObj(employee);
		return employeeDo;
	}

	@Override
	public EmployeeDO updateEmployeeData(int empId, EmployeeDO empDo) {
		EmployeeEntity employee = employeeRepository.findById(empId);
		employee = this.convertEntity(employee, empDo);
		EmployeeEntity updatedEmployee = employeeRepository.save(employee);
		return convertObj(updatedEmployee);
	} 
	
	private EmployeeDO convertObj(EmployeeEntity employee) {
		EmployeeDO employeeDo = new EmployeeDO();
		employeeDo.setName(employee.getName());
		employeeDo.setGender(employee.getGender());
		employeeDo.setImagePath(employee.getImagePath());
		employeeDo.setDepartment(employee.getDepartment());
		employeeDo.setSalary(employee.getSalary());
		employeeDo.setNotes(employee.getNotes());
		employeeDo.setStartDate("");
		return employeeDo;
	}
	
	private EmployeeEntity convertEntity(EmployeeEntity empEntity, EmployeeDO empDo) {
		empEntity.setName(empDo.getName());
		empEntity.setDepartment(empDo.getDepartment());
		empEntity.setGender(empDo.getGender());
		empEntity.setImagePath(empDo.getImagePath());
		empEntity.setSalary(empDo.getSalary());
		empEntity.setNotes(empDo.getNotes());
		empEntity.setStartDate(new Date());
		return empEntity;
	}

}
