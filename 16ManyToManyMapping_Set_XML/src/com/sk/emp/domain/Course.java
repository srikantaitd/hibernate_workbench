package com.sk.emp.domain;

import java.util.Set;

public class Course {

	private int courseID;
	private String courseName;
	private float fee;
	
	private Set<Employee> empList;
	
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public float getFee() {
		return fee;
	}
	public void setFee(float fee) {
		this.fee = fee;
	}
	public Set<Employee> getEmpList() {
		return empList;
	}
	public void setEmpList(Set<Employee> empList) {
		this.empList = empList;
	}
	
}
