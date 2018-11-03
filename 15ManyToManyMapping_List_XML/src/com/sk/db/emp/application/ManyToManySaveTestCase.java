package com.sk.db.emp.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sk.db.utility.HibernateSessionFactory;
import com.sk.emp.domain.Course;
import com.sk.emp.domain.Employee;

public class ManyToManySaveTestCase {

	public static void main(String[] args) {
		Scanner readData = new Scanner(System.in);
		System.out.print("Please Enter Course ID:");
		int courseID = readData.nextInt();
		System.out.println("Please Wait While We Are Processing Your Request...");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException intrupptedEx) {

		}
		//testSaveExistingCourseAddEmployee(courseID);
		//testSaveNewCourseAddEmployee();
		testDeleteCourse();
	}

	private static void testSaveExistingCourseAddEmployee(int courseId) {
		try {
			Course courses=(Course) HibernateSessionFactory.getSession().get(Course.class, courseId);
			HibernateSessionFactory.getSession().beginTransaction();
			System.out.println("-------------------");
			System.out.println("Course ID:"+courses.getCourseID());
			System.out.println("Course Name:"+courses.getCourseName());
			System.out.println("Course Fees:"+courses.getFee());
			System.out.println("-------------------");
			System.out.println("Adding Employees Into This Course :");
			Employee emp1=new Employee();
			emp1.setEmpno(1234);
			emp1.setEname("Mukesh");
			emp1.setSal(2300f);
			
			Employee emp2=new Employee();
			emp2.setEmpno(1235);
			emp2.setEname("Anil");
			emp2.setSal(2300f);
			
			courses.getEmpList().add(emp1);
			courses.getEmpList().add(emp2);
			HibernateSessionFactory.getSession().getTransaction().commit();
			System.out.println("\nThank You For Using Employee Management Services.");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private static void testSaveNewCourseAddEmployee() {
		try {
			Course course=new Course();
			course.setCourseID(13);
			course.setCourseName("BigData");
			course.setFee(6000);
			
			System.out.println("Saving Course Details.");
			System.out.println("-------------------");
			System.out.println("Course ID:"+course.getCourseID());
			System.out.println("Course Name:"+course.getCourseName());
			System.out.println("Course Fees:"+course.getFee());
			System.out.println("-------------------");
			System.out.println("Adding Employees Into This Course :");
			Employee emp1=new Employee();
			emp1.setEmpno(1234);
			emp1.setEname("Mukesh");
			emp1.setSal(2300f);
			
			Employee emp2=new Employee();
			emp2.setEmpno(1235);
			emp2.setEname("Anil");
			emp2.setSal(2300f);
			List<Employee> emps=new ArrayList<>();
			emps.add(emp1);
			emps.add(emp2);
			course.setEmpList(emps);
			HibernateSessionFactory.getSession().beginTransaction();
			HibernateSessionFactory.getSession().save(course);
			HibernateSessionFactory.getSession().getTransaction().commit();
			System.out.println("\nThank You For Using Employee Management Services.");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static void testDeleteCourse() {
		try {
			Course course=new Course();
			course.setCourseID(13);
			
			HibernateSessionFactory.getSession().beginTransaction();
			HibernateSessionFactory.getSession().delete(course);
			HibernateSessionFactory.getSession().getTransaction().commit();
			System.out.println("\nThank You For Using Employee Management Services.");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
