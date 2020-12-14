package com.bridgelabz.employeepayrollapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_DATA")
public class EmployeeEntity {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "NAME", length = 35)
	private String name;
	@Column(name = "IMAGEPATH")
	private String imagePath;
	@Column(name = "GENDER", length = 10)
	private String gender;
	@Column(name = "SALARY")
	private int salary;
	@Column(name = "STARTDATE")
	private Date startDate;
	@Column(name = "DEPARTMENT")
	private String department;
	@Column(name = "NOTES")
	private String notes;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
}
