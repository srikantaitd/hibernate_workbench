package com.sk.db.emp.application;

import java.util.Scanner;

import com.sk.db.utility.HibernateSessionFactory;
import com.sk.emp.domain.Course;
import com.sk.emp.domain.Employee;

public class ManyToManyReadTestCase {

	public static void main(String[] args) {
		Scanner readData = new Scanner(System.in);
		System.out.print("Please Enter Course ID:");
		int courseID = readData.nextInt();
		System.out.println("Searching For Employee Details With Course ID:" + courseID);
		System.out.println("Please Wait While We Are Processing Your Request...");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException intrupptedEx) {

		}
		testReadEmployee(courseID);
	}

	private static void testReadEmployee(int empId) {
		try {

			Employee emp = (Employee) HibernateSessionFactory.getSession().load(Employee.class, empId);
			System.out.println("-------------------");
			System.out.println("Employee ID:" + emp.getEmpno());
			System.out.println("Employee Name:" + emp.getEname());
			System.out.println("Salary    :" + emp.getSal());
			System.out.println("Deptno :" + emp.getDeptno());
			System.out.println("-------------------");
			System.out.println("Course Details:");
			for (Course course : emp.getCourseList()) {
				System.out.println("\n-------------------------------------");
				System.out.println("Course ID:" + course.getCourseID());
				System.out.println("Course Name:" + course.getCourseName());
				System.out.println("Fees     :" + course.getFee());
				System.out.println("-------------------------------------");
			}
			System.out.println("\nThank You For Using Employee Management Services.");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
