package com.sk.emp.vo;
public class EmpMinDetails {
	private String empName, deptName;

	public EmpMinDetails(String empName, String deptName) {
		super();
		this.deptName = deptName;
		this.empName = empName;
	}

	public String getEmpName() {
		return empName;
	}

	public String getDeptName() {
		return deptName;
	}

	@Override
	public String toString() {
		return "EmployeeMinDetails [empName=" + empName + ", deptName=" + deptName + "]";
	}

}
