package com.sk.db.emp.application;

import java.util.List;

import javax.persistence.criteria.Join;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.sk.db.utility.HibernateSessionFactory;
import com.sk.emp.domain.Dept;
import com.sk.emp.domain.PersonalDetails;

public class CriteriaMultiTableApplication {

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
			Criteria criteria = session.createCriteria(Dept.class);
			criteria.createAlias("employees", "e");//INNER JOIN By DEFAULT
			criteria.createAlias("employees", "e",CriteriaSpecification.INNER_JOIN);
			criteria.createAlias("employees", "e",CriteriaSpecification.LEFT_JOIN);
			criteria.createAlias("employees", "e",2);	//RIGHT OUTER JOIN
			criteria.createAlias("employees", "e",CriteriaSpecification.FULL_JOIN);
			ProjectionList projectionList = Projections.projectionList().add(Projections.property("e.ename")).add(Projections.property("deptno"))
					.add(Projections.property("dname")).add(Projections.property("location"));

			criteria.setProjection(projectionList);

			List<Object[]> emps = criteria.list();
			for (Object[] emp : emps) {
				System.out.println("Employee Name:" + emp[0]);
				System.out.println("Department:" + emp[2]);
				System.out.println("Job Location:" + emp[3]);
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
