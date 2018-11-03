package com.sk.db.emp.application;

import java.util.Scanner;

import com.sk.emp.domain.Employee;
import com.sk.emp.repository.EmployeeRepository;
import com.sk.emp.repository.EmployeeRepositoryImpl;

public class ManyToOneReadTestCase {

	public static void main(String[] args) {
		Scanner readData = new Scanner(System.in);
		System.out.print("Please Enter EmployeeID:");
		int empID = readData.nextInt();
		System.out.println("Searching For Employee Details For EmployeeID:" + empID);
		System.out.println("Please Wait While We Are Processing Your Request...");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException intrupptedEx) {

		}
		testReadEmployee(empID);
	}

	private static void testReadEmployee(int empID) {
		try {
			EmployeeRepository readData = new EmployeeRepositoryImpl();
			Employee empObject = readData.getEmployee(empID);
			System.out.println("Employee Details:");
			System.out.println("-------------------------------------");
			System.out.println("\nEmployee ID:" + empObject.getEmpno());
			System.out.println("Name	:" + empObject.getEname());
			System.out.println("Basic Salary :" + empObject.getSal());
			System.out.println("Department:" + empObject.getDeptno());
			System.out.println("-------------------");
			System.out.println("Department Details:");
			System.out.println("-------------------");
			System.out.println("Department Name:" + empObject.getDept().getDname());
			System.out.println("Department ID:" + empObject.getDept().getDeptno());
			System.out.println("Location :" + empObject.getDept().getLocation());
			System.out.println("\nThank You For Using Employee Management Services.");
		} catch (Exception ex) {
			System.out.println("Employee Details Not Found. Error Message From Runtime: " + ex.getMessage());
		}
	}
}
