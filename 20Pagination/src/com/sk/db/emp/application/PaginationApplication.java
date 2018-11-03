package com.sk.db.emp.application;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.sk.db.utility.HibernateSessionFactory;
import com.sk.emp.domain.Dept;
import com.sk.emp.domain.Employee;

public class PaginationApplication {

	private static final String GET_ALL_EMPLOYEES_DEPT = "FROM Employee e,Dept d";

	public static void main(String[] args) {
		System.out.println("Please Wait While We Are Processing Your Request...");

		try {
			Thread.sleep(10);
		} catch (InterruptedException intrupptedEx) {

		}
		getAllEmployeesDept(GET_ALL_EMPLOYEES_DEPT);
	}

	private static void getAllEmployeesDept(String hql) {
		System.out.println("Fetching All Employee & Dept Details From EmployeeMaster.");
		try {
			// Creating the Session Object
			Session hibernateSession = HibernateSessionFactory.getSession();

			// Creating the Query Object From Session
			Query hqlQuery = hibernateSession.createQuery(hql);
			hqlQuery.setMaxResults(2);

			System.out.println("\n\n---------------- Page1 ----------------");
			List<Object[]> emps = hqlQuery.list();
			for (Object[] emp : emps) {
				showEmpDeptDetails((Employee) emp[0], (Dept) emp[1]);
			}
			
			System.out.println("\n\n---------------- Page2 ----------------");
			hqlQuery.setFirstResult(2);
			List<Object[]> emps2 = hqlQuery.list();
			for (Object[] emp : emps) {
				showEmpDeptDetails((Employee) emp[0], (Dept) emp[1]);
			}
			
			System.out.println("\n\n---------------- Page3 ----------------");
			hqlQuery.setFirstResult(4);
			List<Object[]> emps3 = hqlQuery.list();
			for (Object[] emp : emps) {
				showEmpDeptDetails((Employee) emp[0], (Dept) emp[1]);
			}
			
		} catch (HibernateException ex) {
			System.out.println("Hibernnate Exception Raised.");
			ex.printStackTrace();
		} catch (Exception ex) {
			System.out.println("Employee Details Not Found. Error Message From Runtime: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	private static void showEmpDeptDetails(Employee emp, Dept dept) {
		try {
			System.out.println("Employee Details:");
			System.out.println("\n-------------------------------------");
			System.out.println("Employee ID:" + emp.getEmpno());
			System.out.println("Name	:" + emp.getEname());
			System.out.println("Basic Salary :" + emp.getSal());

			System.out.println(emp.getPersonalDetail());
			System.out.println("-------------------------------------");
			System.out.println("\nDepartment:" + emp.getDeptno());
			System.out.println("-------------------");
			System.out.println("Department Name:" + dept.getDname());
			System.out.println("Department ID:" + dept.getDeptno());
			System.out.println("Location :" + dept.getLocation());
			System.out.println("-------------------");

			System.out.println("\nThank You For Using Employee Management Services.");
		} catch (Exception ex) {
			System.out.println("Department Details Not Found. Error Message From Runtime: " + ex.getMessage());
		}
	}

	private static void showEmployee(Employee emp) {
		System.out.println("Employee Details:");
		System.out.println("-------------------------------------");
		System.out.println("\nEmployee ID:" + emp.getEmpno());
		System.out.println("Name	:" + emp.getEname());
		System.out.println("Basic Salary :" + emp.getSal());
		System.out.println("Department:" + emp.getDeptno());
		System.out.println("-------------------");
		System.out.println("Personal Details:");
		System.out.println("-------------------");
		System.out.println("First Name:" + emp.getPersonalDetail().getFname());
		System.out.println("Last Name :" + emp.getPersonalDetail().getLname());
		System.out.println("Email     :" + emp.getPersonalDetail().getEmail());
		System.out.println("Phone No  :" + emp.getPersonalDetail().getMobile());
		System.out.println("Street 	  :" + emp.getPersonalDetail().getStreet());
		System.out.println("City	  :" + emp.getPersonalDetail().getCity());
		System.out.println("State	  :" + emp.getPersonalDetail().getState());
		System.out.println("Country   :" + emp.getPersonalDetail().getCountry());
		System.out.println("PIN Code  :" + emp.getPersonalDetail().getPin());
		System.out.println("\nThank You For Using Employee Management Services.");
		System.out.println("Employee Object Inside PersonalDetails Is : " + emp.getPersonalDetail().getEmployee());
	}
}
