package com.sk.db.emp.application;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.sk.db.utility.HibernateSessionFactory;
import com.sk.emp.domain.Employee;

public class CriteriaAggregatesApplication {

	public static void main(String[] args) {
		projectGroupedColumn();
	}

	private static void projectGroupedColumn() {
		System.out.println("Fetching All Employee & Dept Details From EmployeeMaster.");
		try {
			
			// Creating the Session Object
			Session session = HibernateSessionFactory.getSession();

			// Creating the Criteria Object From Session
			Criteria criteria = session.createCriteria(Employee.class);

			
			ProjectionList projectionList = Projections.projectionList().add(Projections.avg("sal"))
					.add(Projections.count("empno"))
					.add(Projections.groupProperty("deptno"));

			criteria.setProjection(projectionList).addOrder(Order.asc("deptno"));

			List<Object[]> emps = criteria.list();
			for (Object[] emp : emps) {
				System.out.println("\n\n----------------------");
				System.out.println("Avg Sal:" + Float.parseFloat(emp[0]+""));
				System.out.println("Employee Count:" + emp[1]);
				System.out.println("Department:" + emp[2]);
				System.out.println("----------------------");
			}
		} catch (HibernateException ex) {
			System.out.println("Hibernnate Exception Raised.");
			ex.printStackTrace();
		} catch (Exception ex) {
			System.out.println("Employee Details Not Found. Error Message From Runtime: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	private static void projectSummaries() {
		System.out.println("Fetching All Employee & Dept Details From EmployeeMaster.");
		try {
			// Creating the Session Object
			Session session = HibernateSessionFactory.getSession();

			// Creating the Criteria Object From Session
			Criteria criteria = session.createCriteria(Employee.class);

			ProjectionList projectionList = Projections.projectionList().add(Projections.avg("sal"))
					.add(Projections.max("sal")).add(Projections.min("sal")).add(Projections.rowCount())
					.add(Projections.sum("sal"));

			criteria.setProjection(projectionList);

			List<Object[]> emps = criteria.list();
			for (Object[] emp : emps) {
				System.out.println("Avg Sal:" + Math.round(Float.parseFloat(emp[0] + "")));
				System.out.println("Highest Sal:" + emp[1]);
				System.out.println("Lowest Salary :" + emp[2]);
				System.out.println("Employee Count:" + emp[3]);
				System.out.println("Total Investment:" + emp[4]);
			}
		} catch (HibernateException ex) {
			System.out.println("Hibernnate Exception Raised.");
			ex.printStackTrace();
		} catch (Exception ex) {
			System.out.println("Employee Details Not Found. Error Message From Runtime: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

}
