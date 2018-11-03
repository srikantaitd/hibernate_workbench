package com.sk.db.emp.application;

import org.hibernate.Session;

import com.sk.db.utility.HibernateSessionFactory;

public class IdentifierApplication {

	public static void main(String[] args) {
		testSaveDeptIncrement();
	}

	private static void testSaveDeptIncrement() {
		try {
			Session sessionObject = HibernateSessionFactory.getSessionFactory().getCurrentSession();
			sessionObject.getTransaction().begin();
			for (int i = 0; i < 40; i++) {
				com.sk.emp.domain.Dept deptObject = buildDeptInstance();
				sessionObject.save(deptObject);
			}
			sessionObject.getTransaction().commit();
			System.out.println("Department Details Saved With Details:");
//			System.out.println("-------------------------------------");
//			System.out.println("\nDepartment ID:" + deptObject.getDeptno());
//			System.out.println("\nDepartment Name:" + deptObject.getDname());
//			System.out.println("\nLocation :" + deptObject.getLocation());

		} catch (Exception ex) {
			System.out.println("Department Details Could Not be Saved. Error Message From Runtime: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	private static com.sk.emp.domain.Dept buildDeptInstance() {
		com.sk.emp.domain.Dept dept = new com.sk.emp.domain.Dept();
		dept.setDname("Dept-test");
		dept.setLocation("MEXICO");
		return dept;
	}
}
