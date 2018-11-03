package com.sk.db.emp.application;

import java.util.HashSet;

import com.sk.emp.domain.Dept;
import com.sk.emp.domain.Employee;
import com.sk.emp.repository.DeptRepository;
import com.sk.emp.repository.DeptRepositoryImpl;

public class OneToManyDeleteTestCase {

	public static void main(String[] args) {
		System.out.println("Application statred..");
		testSaveDepartment();
	}

	private static void testSaveDepartment() {
		try {
			Dept deptObject = buildDeptInstance(50);
			addEmployeesIntoDept(deptObject);
			DeptRepository saveData = new DeptRepositoryImpl();
			saveData.saveDept(deptObject);
			System.out.println("Employee Details Saved With Details:");
			System.out.println("-------------------------------------");
			System.out.println("\nDepartment ID:" + deptObject.getDeptno());
			System.out.println("Department Name:" + deptObject.getDname());
			System.out.println("Location:" + deptObject.getLocation());
			System.out.println("-------------------------------------");
			System.out.println("\nThank You For Using Employee Management Services.");
		} catch (Exception ex) {
			System.out.println("Department Details Could Not be Saved. Error Message From Runtime: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	private static void addEmployeesIntoDept(Dept deptObject) {
		Employee empInstance=new Employee();
		empInstance.setEmpno(7002);
		empInstance.setEname("E"+empInstance.getEmpno());
		empInstance.setSal((float)empInstance.getEmpno()+500);
		empInstance.setDeptno(deptObject.getDeptno());
		//deptObject.setEmployees(new HashSet<Employee>());
		deptObject.getEmployees().add(empInstance);
	}

	private static Dept buildDeptInstance(int deptno) {
		Dept deptInstance = new Dept();
		deptInstance.setDeptno(70);
		deptInstance.setDname("TEST");
		deptInstance.setLocation("NOIDA");
		return deptInstance;
	}
}
