package com.sk.db.emp.application;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.sk.db.utility.HibernateSessionFactory;
import com.sk.emp.domain.Dept;
import com.sk.emp.domain.Employee;

public class NativeSQLReadTestCase {

	private static final String GET_ALL_EMPLOYEES_CORRESPONDING_DEPT = "SELECT * FROM EMPLOYEEMASTER e INNER JOIN Department d ON e.deptno=d.deptno";

	private static final String GET_ALL_EMPLOYEES_CORRESPONDING_DEPT_JOIN_FETCH = "SELECT e.*,d.* FROM EMPLOYEEMASTER e INNER JOIN Department d ON e.deptno=d.deptno";

	private static final String GET_ALL_EMPLOYEES = "SELECT EMPID,NAME,SAL,DEPTNO,PERSONALID FROM EMPLOYEEMASTER";

	public static void main(String[] args) {
		// getAllEmployeesDept(GET_ALL_EMPLOYEES_CORRESPONDING_DEPT);
		getAllEmployeesDept(GET_ALL_EMPLOYEES_CORRESPONDING_DEPT_JOIN_FETCH);
		// getAllEmployeesDept(GET_ALL_EMPLOYEES);
	}

	private static void getAllEmployeesDept(String SQL) {
		System.out.println("Fetching All Employee & Dept Details From EmployeeMaster.");
		try {
			// Creating the Session Object
			Session hibernateSession = HibernateSessionFactory.getSession();

			// Creating the Query Object From Session
			if (SQL.equals(GET_ALL_EMPLOYEES_CORRESPONDING_DEPT)) {
				SQLQuery sqlQuery = hibernateSession.createSQLQuery(SQL);
//				sqlQuery.addScalar("empid", Hibernate.INTEGER);
//				sqlQuery.addScalar("name", Hibernate.STRING);
//				sqlQuery.addScalar("sal", Hibernate.BIG_DECIMAL);
//				sqlQuery.addScalar("deptno", Hibernate.INTEGER);
//				sqlQuery.addScalar("dname", Hibernate.STRING);
//				sqlQuery.addScalar("loc", Hibernate.STRING);

				List<Object[]> emps = sqlQuery.list();
				for (Object[] emp : emps) {
					for (int i = 0; i < emp.length; i++) {
						System.out.println(emp[i]);
					}
				}
			} else if (SQL.equals(GET_ALL_EMPLOYEES_CORRESPONDING_DEPT_JOIN_FETCH)) {
				SQLQuery sqlQuery2 = hibernateSession.createSQLQuery(SQL);
				sqlQuery2.addEntity("e", Employee.class);
				sqlQuery2.addEntity("d", Dept.class);
				List<Object[]> empslist = sqlQuery2.list();
				System.out.println(empslist);
				for (Object[] empdept : empslist) {
					showEmpDeptDetails((Employee) empdept[0], (Dept) empdept[1]);
				}
			} else {
				SQLQuery sqlQuery3 = hibernateSession.createSQLQuery(SQL).addEntity(Employee.class);
				List<Employee> empsl = sqlQuery3.list();
				System.out.println(empsl);
				for (Employee empobj : empsl) {
					showEmployee(empobj);
				}
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
//		System.out.println("First Name:" + emp.getPersonalDetail().getFname());
//		System.out.println("Last Name :" + emp.getPersonalDetail().getLname());
//		System.out.println("Email     :" + emp.getPersonalDetail().getEmail());
//		System.out.println("Phone No  :" + emp.getPersonalDetail().getMobile());
//		System.out.println("Street 	  :" + emp.getPersonalDetail().getStreet());
//		System.out.println("City	  :" + emp.getPersonalDetail().getCity());
//		System.out.println("State	  :" + emp.getPersonalDetail().getState());
//		System.out.println("Country   :" + emp.getPersonalDetail().getCountry());
//		System.out.println("PIN Code  :" + emp.getPersonalDetail().getPin());
		System.out.println("\nThank You For Using Employee Management Services.");
		// System.out.println("Employee Object Inside PersonalDetails Is : " +
		// emp.getPersonalDetail().getEmployee());
	}
}
