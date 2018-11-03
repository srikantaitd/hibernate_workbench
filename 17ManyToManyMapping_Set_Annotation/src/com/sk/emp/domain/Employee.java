package com.sk.emp.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="EmployeeDetails")
public class Employee {
	// data memebrs
	private Integer empno;
	private String ename;
	private Float sal;
	private Integer deptno;

	private Set<Course> courseList;

	@Id
	@Column(name="EMPID")
	public Integer getEmpno() {
		return empno;
	}

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="EMP_COURSE",joinColumns=@JoinColumn(name="eid"),inverseJoinColumns=@JoinColumn(name="cid"))
	public Set<Course> getCourseList() {
		return courseList;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	@Column(name="NAME")
	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Float getSal() {
		return sal;
	}

	public void setSal(Float sal) {
		this.sal = sal;
	}

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	public void setCourseList(Set<Course> courseList) {
		this.courseList = courseList;
	}

}
