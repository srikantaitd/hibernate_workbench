/**
 * 
 */
package com.sk.emp.repository;

import org.hibernate.Session;

import com.sk.db.emp.application.OneToManySaveTestCase;
import com.sk.db.utility.HibernateSessionFactory;
import com.sk.emp.domain.Dept;

/**
 * @author srika
 *
 */
public class DeptRepositoryImpl implements DeptRepository {

	@Override
	public void updateDept(Dept newDeptObject) {
		Session sessionObject = null;
		try {
			sessionObject = HibernateSessionFactory.getSessionFactory().getCurrentSession();
			sessionObject.getTransaction().begin();
			Dept dept40=(Dept)sessionObject.get(Dept.class, 40);
			//dept40.getEmployees().get(0).setDeptno(30);
			dept40.getEmployees().remove(0);
			sessionObject.update(dept40);
			sessionObject.getTransaction().commit();
		} catch (Exception ex) {
			sessionObject.getTransaction().rollback();
			ex.printStackTrace();
			throw new RuntimeException(ex.getMessage());
		}
	}

	@Override
	public Dept getDept(int deptID) {
		Session sessionObject = null;
		try {
			Dept dept = null;
			sessionObject = HibernateSessionFactory.getSessionFactory().getCurrentSession();
			sessionObject.getTransaction().begin();
			dept = (Dept) sessionObject.get(Dept.class, deptID);
			sessionObject.getTransaction().commit();

			return dept;
		} catch (Exception ex) {
			sessionObject.getTransaction().rollback();
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public void deleteDept(int deptID) {
		Session sessionObject = null;
		try {
			sessionObject = HibernateSessionFactory.getSessionFactory().getCurrentSession();
			sessionObject.getTransaction().begin();
			Dept empObject = (Dept) sessionObject.get(Dept.class, deptID);
			sessionObject.delete(empObject);
			sessionObject.getTransaction().commit();
		} catch (Exception ex) {
			sessionObject.getTransaction().rollback();
			ex.printStackTrace();
			throw new RuntimeException(ex.getMessage());
		}
	}

	@Override
	public void saveDept(Dept deptObject) {
		Session sessionObject = null;
		try {
			sessionObject = HibernateSessionFactory.getSessionFactory().getCurrentSession();
			sessionObject.getTransaction().begin();
			sessionObject.save(deptObject);
			sessionObject.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			sessionObject.getTransaction().rollback();
			throw new RuntimeException(ex.getMessage());
		}
	}
}// class
