package com.interview;

public class Employee {
	private int empId;
	private String fname;
	private String techPlatform;
	private int certificationId;

	public Employee(int empId, String fname, String techPlatform, int certificationId) {
		this.empId = empId;
		this.fname = fname;
		this.techPlatform = techPlatform;
		this.certificationId = certificationId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getTechPlatform() {
		return techPlatform;
	}

	public void setTechPlatform(String techPlatform) {
		this.techPlatform = techPlatform;
	}

	public int getCertificationId() {
		return certificationId;
	}

	public void setCertificationId(int certificationId) {
		this.certificationId = certificationId;
	}

}
