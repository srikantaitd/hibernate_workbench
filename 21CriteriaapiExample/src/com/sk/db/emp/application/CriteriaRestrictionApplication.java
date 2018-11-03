package com.sk.db.emp.application;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.sk.db.utility.HibernateSessionFactory;
import com.sk.emp.domain.Dept;
import com.sk.emp.domain.Employee;

public class CriteriaRestrictionApplication {

	public static void main(String[] args) {
		System.out.println("Please Wait While We Are Processing Your Request...");

		try {
			Thread.sleep(10);
		} catch (InterruptedException intrupptedEx) {

		}
		getAllEmployeesDept();
	}

	private static void getAllEmployeesDept() {
		System.out.println("Fetching All Employee & Dept Details From EmployeeMaster.");
		try {
			// Creating the Session Object
			Session session = HibernateSessionFactory.getSession();

			// Creating the Criteria Object From Session
			Criteria condition = session.createCriteria(Employee.class);
			//ex1.//condition.add(Restrictions.eq("deptno", 10));
			//ex2.//condition.add(Restrictions.between("sal", 500.0, 1500.0));
			//ex3.//condition.add(Restrictions.or(Restrictions.eq("deptno", 10), Restrictions.between("sal", 500.0, 1500.0)));

			//ex4.
			/*
			 * condition.add(Restrictions.and( Restrictions.or(Restrictions.eq("deptno",
			 * 10), Restrictions.between("sal", 500.0, 1500.0)),
			 * Restrictions.or(Restrictions.eq("deptno", 20), Restrictions.between("sal",
			 * 1500.0, 3000.0))));
			 */

			//ex5.
			/*condition.add(Restrictions.or(
					Restrictions.and(Restrictions.eq("deptno", 10), Restrictions.between("sal", 500.0, 1500.0)),
					Restrictions.and(Restrictions.eq("deptno", 20), Restrictions.between("sal", 1500.0, 3000.0))));
*/
			List<Employee> emps = condition.list();
			for (Employee emp : emps) {
				showEmployee(emp);
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
			if (dept != null) {
				System.out.println("\nDepartment:" + emp.getDeptno());
				System.out.println("-------------------");
				System.out.println("Department Name:" + dept.getDname());
				System.out.println("Department ID:" + dept.getDeptno());
				System.out.println("Location :" + dept.getLocation());
				System.out.println("-------------------");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
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
	}
}
