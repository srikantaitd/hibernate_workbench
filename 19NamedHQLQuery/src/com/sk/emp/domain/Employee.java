package com.sk.emp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEEMASTER")
@NamedQueries({ @NamedQuery(name = "GET_ALL_EMPLOYEES", query = "FROM Employee"),
		@NamedQuery(name = "GET_ALL_EMPLOYEES_DEPT", query = "FROM Employee e,Dept d"),
		@NamedQuery(name = "GET_ALL_EMPLOYEES_CORRESPONDING_DEPT_JOIN_FETCH", query = "FROM Employee e JOIN FETCH e.dept d"),
		@NamedQuery(name = "GET_ALL_EMPLOYEES_CORRESPONDING_DEPT_NORELATION", query = "FROM Employee e,Dept d WHERE e.deptno=d.deptno") })
public class Employee {
	// data memebrs
	private Integer empno;
	private String ename;
	private Float sal;
	private Integer deptno;

	private PersonalDetails personalDetail;

	private Dept dept;

	@Id
	@Column(name = "EMPID")
	public Integer getEmpno() {
		return empno;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERSONALID")
	public PersonalDetails getPersonalDetail() {
		return personalDetail;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "deptno", insertable = false, updatable = false)
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
