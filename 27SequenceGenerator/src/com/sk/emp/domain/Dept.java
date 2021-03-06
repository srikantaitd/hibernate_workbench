package com.sk.emp.domain;

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

	/***
	 * org.hibernate.id.SequenceGenerator is deprecated in hibernate 5+ infavor 
	 * of org.hibernate.id.enhanced.SequenceStyleGenerator
	 * @return
	 */
	@Id
	@GeneratedValue(generator = "sequence")
	@GenericGenerator(parameters = @Parameter(name = "sequence", value = "Deptno_Sequence"), name = "sequence", strategy = "org.hibernate.id.SequenceGenerator")
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
