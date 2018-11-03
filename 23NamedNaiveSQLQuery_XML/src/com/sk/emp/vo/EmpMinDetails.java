package com.sk.emp.vo;

public class EmpMinDetails {

	private String ename;
	private String dname;

	public EmpMinDetails(String enam,String dname) {
		this.ename=ename;
		this.dname=dname;
	}
	
	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	@Override
	public String toString() {
		return "EmpMinDetails [ename=" + ename + ", dname=" + dname + "]";
	}

}
