package com.bridgelabz.employeepayrollapp.model;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDO {
	
	@NotEmpty(message = "Name cannot be empty")
	private String name;
	private String imagePath;
	private String gender;
	
	@Min(value = 100, message = "Salary digit should be greater than 1")
	@Max(value = 10000000, message = "Salary digit should be less than 10")
	private int salary;
	private Date startDate;
	private String department;
	private String notes;
	
	@Override
	public String toString() {
		return "EmployeeDO [name=" + name + ", imagePath=" + imagePath + ", gender=" + gender + ", salary=" + salary
				+ ", startDate=" + startDate + ", department=" + department + ", notes=" + notes + "]";
	}
}
