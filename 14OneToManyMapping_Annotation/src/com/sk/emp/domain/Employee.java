package com.sk.emp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "EMPLOYEEMASTER")
public class Employee{
	// data members
	private Integer empno;
	private String ename;
	private Float sal;
	private Integer deptno;

	private Dept dept;
	@Id
	@Column(name = "EMPID")
	public Integer getEmpno() {
		return empno;
	}

	@ManyToOne
	@JoinColumn(name = "deptno",insertable=false,updatable=false)
	public Dept getDept() {
		return dept;
	}

	public Integer getDeptno() {
		return deptno;
	}

	@Column(name = "name")
	public String getEname() {
		return ename;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
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

}
