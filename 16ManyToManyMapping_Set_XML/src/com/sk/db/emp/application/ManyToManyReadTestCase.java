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
		testReadEmployeeFromCourse(courseID);
	}

	private static void testReadEmployeeFromCourse(int courseId) {
		try {

			Course courses=(Course) HibernateSessionFactory.getSession().get(Course.class, courseId);
			System.out.println("-------------------");
			System.out.println("Course ID:"+courses.getCourseID());
			System.out.println("Course Name:"+courses.getCourseName());
			System.out.println("Course Fees:"+courses.getFee());
			System.out.println("-------------------");
			System.out.println("Employee Details:");
			for (Employee emp : courses.getEmpList()) {
				System.out.println("\n-------------------------------------");
				System.out.println("Employee ID:" + emp.getEmpno());
				System.out.println("Name	:" + emp.getEname());
				System.out.println("Basic Salary :" + emp.getSal());
				System.out.println("-------------------------------------");
				//System.out.println("Course Instance Within Employee Object is:" + emp.getCourseList());
			}
			System.out.println("\nThank You For Using Employee Management Services.");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
