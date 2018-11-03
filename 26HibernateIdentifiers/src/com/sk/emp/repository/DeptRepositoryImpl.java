/**
 * 
 */
package com.sk.emp.repository;

import org.hibernate.Session;

import com.sk.db.utility.HibernateSessionFactory;

/**
 * @author srika
 *
 */
public class DeptRepositoryImpl implements DeptRepository {

	@Override
	public void saveDept(com.sk.emp.domain.id.sequence.Dept deptObject) {
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

	@Override
	public void saveDept(com.sk.emp.domain.id.increment.Dept deptObject) {
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
	
	@Override
	public void saveDept(com.sk.emp.domain.id.sequence.hilow.Dept deptObject) {
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
	
	@Override
	public void saveDept(com.sk.emp.domain.id.table.hilow.Dept deptObject) {
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
