package com.sk.emp.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COURSE")
public class Course {

	private int courseID;
	private String courseName;
	private float fee;

	private Set<Employee> empList;

	@Id
	public int getCourseID() {
		return courseID;
	}

	@Column(name = "FEES")
	public float getFee() {
		return fee;
	}

	@ManyToMany(mappedBy = "courseList")
	public Set<Employee> getEmpList() {
		return empList;
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

	public void setFee(float fee) {
		this.fee = fee;
	}

	public void setEmpList(Set<Employee> empList) {
		this.empList = empList;
	}

}
