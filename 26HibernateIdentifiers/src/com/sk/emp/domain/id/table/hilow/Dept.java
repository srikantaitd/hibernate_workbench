package com.sk.emp.domain.id.table.hilow;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "Department")
public class Dept {
	private Integer deptno;
	private String dname;
	private String location;

	@Id
	@GeneratedValue(generator = "table_hilo")
	@GenericGenerator(parameters = { @Parameter(name = "max_low", value = "2"),
			@Parameter(name = "table", value = "Deptno_Gen_Hilow"),
			@Parameter(name = "column", value = "Deptno_Global_High") }, name = "table_hilo", strategy = "org.hibernate.id.enhanced.TableGenerator")
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
