package com.sk.db.emp.application;

import com.sk.emp.repository.DeptRepository;
import com.sk.emp.repository.DeptRepositoryImpl;

public class IdentifierApplication {

	public static void main(String[] args) {
		testSaveDeptIncrement();
	}

	private static void testSaveDeptIncrement() {
		try {
			com.sk.emp.domain.Dept deptObject = buildDeptIncrementInstance();
			DeptRepository saveData = new DeptRepositoryImpl();
			saveData.saveDept(deptObject);
			System.out.println("Department Details Saved With Details:");
			System.out.println("-------------------------------------");
			System.out.println("\nDepartment ID:" + deptObject.getDeptno());
			System.out.println("\nDepartment Name:" + deptObject.getDname());
			System.out.println("\nLocation :" + deptObject.getLocation());
		} catch (Exception ex) {
			System.out.println("Department Details Could Not be Saved. Error Message From Runtime: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	private static com.sk.emp.domain.Dept buildDeptIncrementInstance() {
		com.sk.emp.domain.Dept dept = new com.sk.emp.domain.Dept();
		dept.setDname("Dept-test");
		dept.setLocation("MEXICO");
		return dept;
	}
}
