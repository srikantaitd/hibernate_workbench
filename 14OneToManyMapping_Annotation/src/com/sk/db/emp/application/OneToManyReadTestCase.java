package com.sk.db.emp.application;

import java.util.Scanner;

import com.sk.emp.domain.Dept;
import com.sk.emp.domain.Employee;
import com.sk.emp.repository.DeptRepository;
import com.sk.emp.repository.DeptRepositoryImpl;

public class OneToManyReadTestCase {

	public static void main(String[] args) {
		Scanner readData = new Scanner(System.in);
		System.out.print("Please Enter Department No:");
		int deptno = readData.nextInt();
		System.out.println("Searching For Employee Details In Depatment No:" + deptno);
		System.out.println("Please Wait While We Are Processing Your Request...");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException intrupptedEx) {

		}
		testReadEmployeeFromDept(deptno);
	}

	private static void testReadEmployeeFromDept(int deptno) {
		try {
			DeptRepository readData = new DeptRepositoryImpl();
			Dept deptObject = readData.getDept(deptno);
			System.out.println("-------------------");
			System.out.println("Department Name:" + deptObject.getDname());
			System.out.println("Department ID:" + deptObject.getDeptno());
			System.out.println("Location :" + deptObject.getLocation());
			System.out.println("-------------------");
			System.out.println("Employee Details:");
			for (Employee emp : deptObject.getEmployees()) {
				System.out.println("\n-------------------------------------");
				System.out.println("Employee ID:" + emp.getEmpno());
				System.out.println("Name	:" + emp.getEname());
				System.out.println("Basic Salary :" + emp.getSal());
				
				System.out.println("Department:" + emp.getDeptno());
				System.out.println("-------------------------------------");
				//System.out.println("Department Instance Within Employee Object is:" + emp.getDept());
			}
			System.out.println("\nThank You For Using Employee Management Services.");
		} catch (Exception ex) {
			System.out.println("Department Details Not Found. Error Message From Runtime: " + ex.getMessage());
		}
	}
}
