package com.afsal.emc.emc_backend.dto;




public class EmployeeDto {

	private long id;
	private String name;
	private String email;
	private String position;
	private Double salary;
	private String phone;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public EmployeeDto(long id, String name, String email, String position, Double salary, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.position = position;
		this.salary = salary;
		this.phone = phone;
	}
	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
