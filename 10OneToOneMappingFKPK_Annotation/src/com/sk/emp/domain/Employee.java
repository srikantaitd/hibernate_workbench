package com.sk.emp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEEMASTER")
public class Employee {
	// data memebrs
	private Integer empno;
	private String ename;
	private Float sal;
	private Integer deptno;

	private PersonalDetails personalDetail;

	@Id
	@Column(name = "EMPID")
	public Integer getEmpno() {
		return empno;
	}

	@OneToOne
	@JoinColumn(name = "PERSONALID")
	public PersonalDetails getPersonalDetail() {
		return personalDetail;
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
}
