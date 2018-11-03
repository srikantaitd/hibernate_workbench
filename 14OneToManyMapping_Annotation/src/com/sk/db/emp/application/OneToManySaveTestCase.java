package com.sk.db.emp.application;

import com.sk.emp.domain.Dept;
import com.sk.emp.domain.Employee;
import com.sk.emp.repository.DeptRepository;
import com.sk.emp.repository.DeptRepositoryImpl;

public class OneToManySaveTestCase {

	public static void main(String[] args) {
		System.out.println("Application statred..");
		// testAddingIntoMap();
		 testDeleteDept();
//		testRemovingEmployeeFromMap();
	}

	private static void testDeleteDept() {
		try {
			DeptRepository saveData = new DeptRepositoryImpl();
			saveData.deleteDept(30);
			System.out.println("Dept Deleted Successfully.");
		} catch (Exception ex) {
			System.out.println("Department Details Could Not be Saved. Error Message From Runtime: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	private static void testAddingIntoMap() {
		try {
			Dept deptObject = getDept(10);
			addEmployeesIntoDept(deptObject);
			DeptRepository saveData = new DeptRepositoryImpl();
			saveData.updateDept(deptObject);
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

	private static void testRemovingEmployeeFromMap() {
		try {
			//Dept deptObject = getDept(40);
			//removeEmployeesFromDept(deptObject);
			DeptRepository saveData = new DeptRepositoryImpl();
			saveData.updateDept(null);
			System.out.println("Employee Details Saved With Details:");
			System.out.println("-------------------------------------");
//			System.out.println("\nDepartment ID:" + deptObject.getDeptno());
//			System.out.println("Department Name:" + deptObject.getDname());
//			System.out.println("Location:" + deptObject.getLocation());
			System.out.println("-------------------------------------");
			System.out.println("\nThank You For Using Employee Management Services.");
		} catch (Exception ex) {
			System.out.println("Department Details Could Not be Saved. Error Message From Runtime: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public static void removeEmployeesFromDept(Dept deptObject) {
		if (!deptObject.getEmployees().isEmpty()) {
			Employee emp1=null;
			for(Employee e:deptObject.getEmployees()) {
				emp1=e;
			}
			deptObject.getEmployees().remove(emp1);
		} else {
			System.out.println("Employee Map is Empty");
		}

	}

	private static void addEmployeesIntoDept(Dept deptObject) {

		Employee empInstance = new Employee();
		empInstance.setEmpno(7006);
		empInstance.setEname("E" + empInstance.getEmpno());
		empInstance.setSal((float) empInstance.getEmpno() + 500);
		empInstance.setDeptno(deptObject.getDeptno());
		if (deptObject.getEmployees().isEmpty()) {
			//deptObject.setEmployees(new HashSet<Employee>());
		}
		deptObject.getEmployees().add(empInstance);
	}

	private static Dept getDept(int deptno) {
		DeptRepository deptRepository = new DeptRepositoryImpl();
		return deptRepository.getDept(deptno);
	}
}
