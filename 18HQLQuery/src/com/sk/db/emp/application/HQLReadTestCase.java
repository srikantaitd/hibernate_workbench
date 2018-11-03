package com.sk.db.emp.application;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.sk.db.utility.HibernateSessionFactory;
import com.sk.emp.domain.Dept;
import com.sk.emp.domain.Employee;
import com.sk.emp.vo.EmpMinDetails;

public class HQLReadTestCase {

	private static final String GET_ALL_EMPLOYEES = "FROM Employee";
	private static final String GET_ALL_EMPLOYEES_DEPT = "FROM Employee e,Dept d";
	private static final String GET_ALL_EMPLOYEES_DEPT_MIN_DETAILS = "select new com.sk.emp.vo.EmpMinDetails(e.ename,d.dname) FROM Employee e JOIN e.dept d";
	private static final String GET_ALL_EMPLOYEES_CORRESPONDING_DEPT = "FROM Employee e JOIN e.dept d";
	private static final String GET_ALL_EMPLOYEES_CORRESPONDING_DEPT_JOIN_FETCH = "FROM Employee e JOIN FETCH e.dept d";

	private static final String GET_ALL_EMPLOYEES_CORRESPONDING_DEPT_NORELATION = "FROM Employee e,Dept d WHERE e.deptno=d.deptno";

	public static void main(String[] args) {
		// Scanner readData = new Scanner(System.in);
		// System.out.print("Search Employee Details By Name:");
		// String ename = readData.next();
		// System.out.println("Searching For " + ename + " Employee Details.");
		System.out.println("Please Wait While We Are Processing Your Request...");

		try {
			Thread.sleep(10);
		} catch (InterruptedException intrupptedEx) {

		}
		// getAllEmployees();
//		 getAllEmployeesDept(GET_ALL_EMPLOYEES_DEPT);
//		getAllEmployeesDept(GET_ALL_EMPLOYEES_CORRESPONDING_DEPT);
		// getAllEmployeesDept(GET_ALL_EMPLOYEES_CORRESPONDING_DEPT_JOIN_FETCH);
//		getAllEmployeesDept(GET_ALL_EMPLOYEES_CORRESPONDING_DEPT_NORELATION);
		getAllEmployeesDept(GET_ALL_EMPLOYEES_DEPT_MIN_DETAILS);

	}

	private static void getAllEmployees() {
		System.out.println("Fetching All Employee Details From EmployeeMaster.");
		try {
			// Creating the Session Object
			Session hibernateSession = HibernateSessionFactory.getSession();

			// Creating the Query Object From Session
			Query hqlQuery = hibernateSession.createQuery(GET_ALL_EMPLOYEES);

			List<Employee> emps = hqlQuery.list();

			for (Employee emp : emps) {
				showEmployee(emp);
			}

		} catch (HibernateException ex) {
			System.out.println("Hibernnate Exception Raised.");
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static void getAllEmployeesDept(String hql) {
		System.out.println("Fetching All Employee & Dept Details From EmployeeMaster.");
		try {
			// Creating the Session Object
			Session hibernateSession = HibernateSessionFactory.getSession();

			// Creating the Query Object From Session
			Query hqlQuery = hibernateSession.createQuery(hql);

			if (hql.equals(GET_ALL_EMPLOYEES_CORRESPONDING_DEPT)
					|| hql.equals(GET_ALL_EMPLOYEES_CORRESPONDING_DEPT_NORELATION)
					|| hql.equals(GET_ALL_EMPLOYEES_DEPT)) {
				List<Object[]> emps = hqlQuery.list();
				for (Object[] emp : emps) {
					showEmpDeptDetails((Employee) emp[0], (Dept) emp[1]);
				}
			} else if (hql.equals(GET_ALL_EMPLOYEES_CORRESPONDING_DEPT_JOIN_FETCH)) {
				List<Employee> emps = hqlQuery.list();
				for (Employee emp : emps) {
					showEmpDeptDetails(emp, emp.getDept());
				}
			} else if (hql.equals(GET_ALL_EMPLOYEES_DEPT_MIN_DETAILS)) {
				//NOT WORKING
				List<EmpMinDetails> emps = hqlQuery.list();
				for (EmpMinDetails emp : emps) {
					System.out.println(emp);
				}
			} else {
				List<Object[]> emps = hqlQuery.list();
				System.out.println(emps);
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
