package com.sk.emp.domain;

import java.util.List;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Department")
public class Dept {
	private Integer deptno;
	private String dname;
	private String location;

	/*private List<Employee> employees;

	@OneToMany(fetch=FetchType.LAZY,mappedBy="dept")
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
*/
	@Id
	public Integer getDeptno() {
		return deptno;
	}

	@Column(name = "loc")
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

}
