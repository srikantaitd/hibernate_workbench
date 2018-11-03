package com.sk.db.emp.application;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.sk.db.utility.HibernateSessionFactory;
import com.sk.emp.domain.Employee;

public class DetachedCriteriaApplication {

	public static void main(String[] args) {
		System.out.println("Please Wait While We Are Processing Your Request...");

		try {
			Thread.sleep(10);
		} catch (InterruptedException intrupptedEx) {

		}
		projectFromMultipleTable();
	}

	/**
	 * 
	 */
	private static void projectFromMultipleTable() {
		System.out.println("Fetching All Employee & Dept Details From EmployeeMaster.");
		try {
			// Creating the Session Object
			Session session = HibernateSessionFactory.getSession();

			// Creating the Criteria Object From Session
			DetachedCriteria detached = DetachedCriteria.forClass(Employee.class);

			Criteria criteria = detached.getExecutableCriteria(session);
			criteria.createAlias("dept", "d");// INNER JOIN By DEFAULT
//			criteria.createAlias("dept", "d",CriteriaSpecification.INNER_JOIN);
//			criteria.createAlias("dept", "d",CriteriaSpecification.LEFT_JOIN);
//			criteria.createAlias("dept", "d",2);	//RIGHT OUTER JOIN
//			criteria.createAlias("dept", "d",CriteriaSpecification.FULL_JOIN);

			ProjectionList projectionList = Projections.projectionList().add(Projections.property("ename"))
					.add(Projections.property("deptno")).add(Projections.property("d.dname"))
					.add(Projections.property("d.location"));

			criteria.setProjection(projectionList);

			List<Object[]> emps = criteria.list();
			for (Object[] emp : emps) {
				System.out.println("Employee Name:" + emp[0]);
				System.out.println("Department:" + emp[2]);
				System.out.println("Job Location:" + emp[3]);
			}
			session.close();
			new Thread(new Runnable() {
				public void run() {
					try {
						System.out.println("\n\nNew Session Created.\n\n");
						Session session2 = HibernateSessionFactory.getSession();
						Criteria criteria2 = detached.getExecutableCriteria(session2);

						List<Object[]> emps2 = criteria2.list();
						for (Object[] emp : emps2) {
							System.out.println("Employee Name:" + emp[0]);
							System.out.println("Department:" + emp[2]);
							System.out.println("Job Location:" + emp[3]);
						}
						session2.close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}).start();
		} catch (HibernateException ex) {
			System.out.println("Hibernnate Exception Raised.");
			ex.printStackTrace();
		} catch (Exception ex) {
			System.out.println("Employee Details Not Found. Error Message From Runtime: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}
