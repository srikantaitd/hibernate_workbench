package com.sk.emp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEEMASTER")
@NamedNativeQueries({
		@NamedNativeQuery(name = "GET_ALL_EMPLOYEES", query = "SELECT * FROM EMPLOYEEMASTER E", resultClass = Employee.class),
		@NamedNativeQuery(name = "GET_ALL_EMPLOYEES_2", query = "SELECT E.EmpId as MyEmpno,E.Name MyName,E.Sal,E.Deptno FROM EMPLOYEEMASTER E", resultSetMapping = "emp_mapping"),
		@NamedNativeQuery(name = "GET_ALL_DEPT", query = "SELECT D.Deptno as MyDeptno,D.Dname AS MyDname,D.Loc as Location FROM DEPARTMENT D", resultSetMapping = "dept_mapping"),
		@NamedNativeQuery(name = "GET_ALL_DEPT_EMPLOYEES", query = "SELECT E.Name AS EmpName,E.EmpId AS EmployeeId,E.Sal,E.Deptno,D.Dname,D.Loc FROM Employee E,Dept D WHERE E.Deptno=D.Deptno", resultSetMapping = "emp_dept_mapping"),
		//@NamedNativeQuery(name = "GET_CUSTOM_DATA", query = "SELECT E.Name AS EmpName,D.Dname,D.Loc FROM Employee E,Dept D WHERE E.Deptno=D.Deptno", resultSetMapping = "custom_obj_mapping")
		})
		
@SqlResultSetMappings(value = {
		@SqlResultSetMapping(name = "emp_mapping", entities = { @EntityResult(entityClass = Employee.class, fields = {
				@FieldResult(name = "empno", column = "MyEmpno"), @FieldResult(name = "ename", column = "MyName"),
				@FieldResult(name = "sal", column = "sal"), @FieldResult(name = "deptno", column = "deptno") }) }

		),
		@SqlResultSetMapping(name = "dept_mapping", entities = { @EntityResult(entityClass = Dept.class, fields = {
				@FieldResult(name = "deptno", column = "MyDeptno"), @FieldResult(name = "dname", column = "MyDname"),
				@FieldResult(name = "location", column = "LOCATION") }) }

		),
		@SqlResultSetMapping(name = "emp_dept_mapping", entities = {
				@EntityResult(entityClass = Employee.class, fields = {
						@FieldResult(name = "empno", column = "EmployeeId"),
						@FieldResult(name = "ename", column = "EmpName"), @FieldResult(name = "sal", column = "Sal"),
						@FieldResult(name = "deptno", column = "Deptno") }),
				@EntityResult(entityClass = Dept.class, fields = { @FieldResult(name = "deptno", column = "deptno"),
						@FieldResult(name = "dname", column = "Dname"),
						@FieldResult(name = "location", column = "Loc") }) }) })

public class Employee {
	// data memebrs
	private Integer empno;
	private String ename;
	private Float sal;
	private Integer deptno;

//	private PersonalDetails personalDetail;
//
//	private Dept dept;

	@Id
	@Column(name = "EMPID")
	public Integer getEmpno() {
		return empno;
	}

	/*
	 * @OneToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "PERSONALID") public PersonalDetails getPersonalDetail() {
	 * return personalDetail; }
	 * 
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "deptno", insertable = false, updatable = false) public
	 * Dept getDept() { return dept; }
	 * 
	 * public void setDept(Dept dept) { this.dept = dept; }
	 * 
	 * public void setPersonalDetail(PersonalDetails personalDetail) {
	 * this.personalDetail = personalDetail; }
	 * 
	 */ public void setEmpno(Integer empno) {
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
