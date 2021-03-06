package com.sk.db.emp.application;

import java.sql.Date;

import com.sk.emp.domain.Employee;
import com.sk.emp.repository.EmployeeRepository;
import com.sk.emp.repository.EmployeeRepositoryImpl;

public class EmployeeMainApplication {

	public static void main(String[] args) {
		System.out.println("Application statred..");
		testSaveEmployee();
	}

	private static void testSaveEmployee() {
		try {
			Employee empObject = buildEmployeeInstance(2);
			EmployeeRepository saveData = new EmployeeRepositoryImpl();
			saveData.saveEmployee(empObject);
			System.out.println("Employee Details Saved With Details:");
			System.out.println("-------------------------------------");
			System.out.println("\nEmployee ID:"+empObject.getEmpno());
			System.out.println("\n          Name:"+empObject.getEname());
			System.out.println("\n  Designation:"+empObject.getJob());
			System.out.println("\n  Manager ID:"+empObject.getMgr());
			System.out.println("\n Joining Date:"+empObject.getHiredate());
			System.out.println("\n Basic Salary:"+empObject.getSal());
			System.out.println("\n  Commision:"+empObject.getComm());
			System.out.println("\n Department:"+empObject.getDeptno());
			System.out.println("\n\nThank You For Using Employee Management Services.");
		} catch (Exception ex) {
			System.out.println("Employee Details Could Not be Saved. Error Message From Runtime: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	private static Employee buildEmployeeInstance(int sequence) {
		Employee empInstance=new Employee();
		empInstance.setEmpno(100*10+sequence);
		empInstance.setEname("E"+empInstance.getEmpno());
		empInstance.setJob("SALESMAN");
		empInstance.setMgr(7839);
		empInstance.setHiredate(new Date(System.currentTimeMillis()));
		empInstance.setSal((float)empInstance.getEmpno()+500);
		empInstance.setComm(400);
		empInstance.setDeptno(10*sequence);
		return empInstance;
	}
}
