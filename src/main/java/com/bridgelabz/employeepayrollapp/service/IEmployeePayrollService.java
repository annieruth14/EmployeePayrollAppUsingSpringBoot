package com.bridgelabz.employeepayrollapp.service;

import java.util.List;

import com.bridgelabz.employeepayrollapp.model.EmployeeDO;
import com.bridgelabz.employeepayrollapp.model.ResponseDO;

public interface IEmployeePayrollService {
	
	public ResponseDO addEmployee(EmployeeDO empDo);
	public List<EmployeeDO> getEmployeeList();
	public ResponseDO deleteEmployee(int id);
	public EmployeeDO findEmployee(int id);
	public EmployeeDO updateEmployeeData(int empId, EmployeeDO empDo);
}
