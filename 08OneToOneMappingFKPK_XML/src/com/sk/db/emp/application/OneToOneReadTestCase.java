package com.sk.db.emp.application;

import java.util.Scanner;

import com.sk.emp.domain.Employee;
import com.sk.emp.domain.PersonalDetails;
import com.sk.emp.repository.EmployeeRepository;
import com.sk.emp.repository.EmployeeRepositoryImpl;
import com.sk.emp.repository.PersonalDetailsRepository;
import com.sk.emp.repository.PersonalDetailsRepositoryImpl;

public class OneToOneReadTestCase {

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
		//testReadEmployee(empID);
		testBiDirectionalFlow(empID);
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
			System.out.println("Personal Details:");
			System.out.println("-------------------");
			System.out.println("First Name:" + empObject.getPersonalDetail().getFname());
			System.out.println("Last Name :" + empObject.getPersonalDetail().getLname());
			System.out.println("Email     :" + empObject.getPersonalDetail().getEmail());
			System.out.println("Phone No  :" + empObject.getPersonalDetail().getMobile());
			System.out.println("Street 	  :" + empObject.getPersonalDetail().getStreet());
			System.out.println("City	  :" + empObject.getPersonalDetail().getCity());
			System.out.println("State	  :" + empObject.getPersonalDetail().getState());
			System.out.println("Country   :" + empObject.getPersonalDetail().getCountry());
			System.out.println("PIN Code  :" + empObject.getPersonalDetail().getPin());
			System.out.println("\nThank You For Using Employee Management Services.");
			
			System.out.println("Employee Object Inside PersonDetails Is : "+empObject.getPersonalDetail().getEmployee());
		} catch (Exception ex) {
			System.out.println("Employee Details Not Found. Error Message From Runtime: " + ex.getMessage());
		}
	}
	
	private static void testBiDirectionalFlow(int pesonalID) {
		PersonalDetailsRepository personalDetailsRepository = new PersonalDetailsRepositoryImpl();
		PersonalDetails personalDetails = personalDetailsRepository.getPDetails(pesonalID);
		System.out.println("-------------------");
		System.out.println("Personal Details:");
		System.out.println("-------------------");
		System.out.println("First Name:" + personalDetails.getFname());
		System.out.println("Last Name :" + personalDetails.getLname());
		System.out.println("Email     :" + personalDetails.getEmail());
		System.out.println("Phone No  :" + personalDetails.getMobile());
		System.out.println("Street 	  :" + personalDetails.getStreet());
		System.out.println("City	  :" + personalDetails.getCity());
		System.out.println("State	  :" + personalDetails.getState());
		System.out.println("Country   :" + personalDetails.getCountry());
		System.out.println("PIN Code  :" + personalDetails.getPin());
		System.out.println("-------------------------------------");
		System.out.println("Employee Details Within PersonalDeatils:");
		System.out.println("-------------------------------------");
		System.out.println("\nEmployee ID:" + personalDetails.getEmployee().getEmpno());
		System.out.println("Name	:" + personalDetails.getEmployee().getEname());
		System.out.println("Basic Salary :" + personalDetails.getEmployee().getSal());
		System.out.println("Department:" + personalDetails.getEmployee().getDeptno());
	}
}
