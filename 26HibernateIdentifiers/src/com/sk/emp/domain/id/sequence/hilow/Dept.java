package com.sk.emp.domain.id.sequence.hilow;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
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
	@GeneratedValue(generator = "sequence_hilo")
	@GenericGenerator(parameters = { @Parameter(name = "sequence", value = "Deptno_Sequence"),
			@Parameter(name = "max_low", value = "10") }, name = "sequence_hilo", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator")
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
