package com.sk.db.emp.application;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.sk.db.utility.HibernateSessionFactory;
import com.sk.emp.domain.Employee;
import com.sk.emp.domain.PersonalDetails;

public class CriteriaProjectionApplication {

	public static void main(String[] args) {
		System.out.println("Please Wait While We Are Processing Your Request...");

		try {
			Thread.sleep(10);
		} catch (InterruptedException intrupptedEx) {

		}
		// projectSingleColumn();

		projectMultipleColumn();
	}

	private static void projectSingleColumn() {
		System.out.println("Fetching All Employee & Dept Details From EmployeeMaster.");
		try {
			// Creating the Session Object
			Session session = HibernateSessionFactory.getSession();

			// Creating the Criteria Object From Session
			Criteria condition = session.createCriteria(Employee.class);
			condition.setProjection(Projections.property("ename"));
			List<String> emps = condition.list();
			for (String emp : emps) {
				System.out.println(emp);
			}
		} catch (HibernateException ex) {
			System.out.println("Hibernnate Exception Raised.");
			ex.printStackTrace();
		} catch (Exception ex) {
			System.out.println("Employee Details Not Found. Error Message From Runtime: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	private static void projectMultipleColumn() {
		System.out.println("Fetching All Employee & Dept Details From EmployeeMaster.");
		try {
			// Creating the Session Object
			Session session = HibernateSessionFactory.getSession();

			// Creating the Criteria Object From Session
			Criteria criteria = session.createCriteria(Employee.class);

			ProjectionList projectionList = Projections.projectionList().add(Projections.property("empno"))
					.add(Projections.property("ename")).add(Projections.property("sal"))
					.add(Projections.property("deptno")).add(Projections.property("personalDetail"));

			criteria.setProjection(projectionList);

			List<Object[]> emps = criteria.list();
			for (Object[] emp : emps) {
				System.out.println("Employee ID:" + emp[0]);
				System.out.println("Name	:" + emp[1]);
				System.out.println("Basic Salary :" + emp[2]);
				System.out.println("Department:" + emp[3]);
				showPersonalDetail((PersonalDetails) emp[4]);
			}
		} catch (HibernateException ex) {
			System.out.println("Hibernnate Exception Raised.");
			ex.printStackTrace();
		} catch (Exception ex) {
			System.out.println("Employee Details Not Found. Error Message From Runtime: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	private static void showPersonalDetail(PersonalDetails pdetails) {
		System.out.println("-------------------");
		System.out.println("Personal Details:");
		System.out.println("-------------------");
		System.out.println("First Name:" + pdetails.getFname());
		System.out.println("Last Name :" + pdetails.getLname());
		System.out.println("Email     :" + pdetails.getEmail());
		System.out.println("Phone No  :" + pdetails.getMobile());
		System.out.println("Street 	  :" + pdetails.getStreet());
		System.out.println("City	  :" + pdetails.getCity());
		System.out.println("State	  :" + pdetails.getState());
		System.out.println("Country   :" + pdetails.getCountry());
		System.out.println("PIN Code  :" + pdetails.getPin());
		System.out.println("\nThank You For Using Employee Management Services.");
	}
}
