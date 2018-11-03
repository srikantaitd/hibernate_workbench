package com.sk.emp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEEMASTER")
public class Employee {
	// data memebrs
	private Integer empno;
	private String ename;
	private Double sal;
	private Integer deptno;

	private PersonalDetails personalDetail;
	
	private Dept dept;

	@Id
	@Column(name = "EMPID")
	public Integer getEmpno() {
		return empno;
	}

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "PERSONALID")
	public PersonalDetails getPersonalDetail() {
		return personalDetail;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="deptno",insertable=false,updatable=false)
	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}
	
	public void setPersonalDetail(PersonalDetails personalDetail) {
		this.personalDetail = personalDetail;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	@Column(name = "name")
	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Double getSal() {
		return sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

}
