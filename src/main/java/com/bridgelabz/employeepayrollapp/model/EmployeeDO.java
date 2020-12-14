package com.bridgelabz.employeepayrollapp.model;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class EmployeeDO {
	
	private String name;
	private String imagePath;
	private String gender;
	private int salary;
	private String startDate;
	private String department;
	private String notes;
	
	@Override
	public String toString() {
		return "EmployeeDO [name=" + name + ", imagePath=" + imagePath + ", gender=" + gender + ", salary=" + salary
				+ ", startDate=" + startDate + ", department=" + department + ", notes=" + notes + "]";
	}
}
