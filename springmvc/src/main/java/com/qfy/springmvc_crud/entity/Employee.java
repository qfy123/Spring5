package com.qfy.springmvc_crud.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Past;
import java.util.Date;

public class Employee {
	/*
	JavaBean后端数据校验：
		1、导包
		2、给需要校验的属性添加注解
		3、在SpringMVC封装对象的时候告诉SpringMVC该JavaBean需要校验，转到EmployeeController
	 */
	private Integer id;
	@NotEmpty
	@Length(min = 6,max = 12)
	private String lastName;
	@Email
	private String email;
	//1 male, 0 female
	private Integer gender;
	//规定日期模式
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past//必须是过去的时间
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date birth=new Date();

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}
	@JsonIgnore
	private Department department;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Employee(Integer id, String lastName, String email, Integer gender,
			Department department) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.department = department;
	}

	public Employee() {
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", gender=" + gender +
				", birth=" + birth +
				", department=" + department +
				'}';
	}
}
