package com.sk.db.emp.application;

import com.sk.emp.repository.DeptRepository;
import com.sk.emp.repository.DeptRepositoryImpl;

public class IdentifierApplication {

	public static void main(String[] args) {
		// testSaveDeptIncrement();
		// testSaveDeptSequence();
		testSaveDeptSequenceHilow();
		//testSaveDeptTableHilow();
	}

	private static void testSaveDeptIncrement() {
		try {
			com.sk.emp.domain.id.increment.Dept deptObject = buildDeptIncrementInstance();
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

	private static void testSaveDeptSequence() {
		try {
			com.sk.emp.domain.id.sequence.Dept deptObject = buildDeptSequenceInstance();
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

	private static void testSaveDeptSequenceHilow() {
		try {
			com.sk.emp.domain.id.sequence.hilow.Dept deptObject = buildDeptHilowInstance();
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
	
	private static void testSaveDeptTableHilow() {
		try {
			com.sk.emp.domain.id.table.hilow.Dept deptObject = buildDeptTableHilowInstance();
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
	

	private static com.sk.emp.domain.id.table.hilow.Dept buildDeptTableHilowInstance() {
		com.sk.emp.domain.id.table.hilow.Dept dept = new com.sk.emp.domain.id.table.hilow.Dept();
		dept.setDname("Dept-test");
		dept.setLocation("MEXICO");
		return dept;
	}
	
	private static com.sk.emp.domain.id.sequence.hilow.Dept buildDeptHilowInstance() {
		com.sk.emp.domain.id.sequence.hilow.Dept dept = new com.sk.emp.domain.id.sequence.hilow.Dept();
		dept.setDname("Dept-test");
		dept.setLocation("MEXICO");
		return dept;
	}

	private static com.sk.emp.domain.id.sequence.Dept buildDeptSequenceInstance() {
		com.sk.emp.domain.id.sequence.Dept dept = new com.sk.emp.domain.id.sequence.Dept();
		dept.setDname("Dept-test");
		dept.setLocation("MEXICO");
		return dept;
	}

	private static com.sk.emp.domain.id.increment.Dept buildDeptIncrementInstance() {
		com.sk.emp.domain.id.increment.Dept dept = new com.sk.emp.domain.id.increment.Dept();
		dept.setDname("Dept-test");
		dept.setLocation("MEXICO");
		return dept;
	}
}
