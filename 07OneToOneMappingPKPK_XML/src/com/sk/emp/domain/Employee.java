package com.sk.emp.domain;

public class Employee {
	// data memebrs
	private Integer empno;
	private String ename;
	private Float sal;
	private Integer deptno;

	private PersonalDetails personalDetail;
	
	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

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

	public PersonalDetails getPersonalDetail() {
		return personalDetail;
	}

	public void setPersonalDetail(PersonalDetails personalDetail) {
		this.personalDetail = personalDetail;
	}
}
