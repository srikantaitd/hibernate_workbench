/**
 * 
 */
package com.sk.emp.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sk.db.utility.HibernateSessionFactory;
import com.sk.emp.domain.Employee;

/**
 * @author srika
 *
 */
public class EmployeeRepositoryImpl implements EmployeeRepository {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sk.emp.repository.EmployeeRepository#saveEmployee(com.sk.emp.domain.
	 * Employee)
	 */
	@Override
	public void saveEmployee(Employee empObject) {
		Session sessionObject = null;
		try {
			sessionObject = HibernateSessionFactory.getSession();
			sessionObject.getTransaction().begin();
			sessionObject.save(empObject);
			sessionObject.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			sessionObject.getTransaction().rollback();
			throw new RuntimeException(ex.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sk.emp.repository.EmployeeRepository#updateEmployee(com.sk.emp.domain.
	 * Employee)
	 */
	@Override
	public void updateEmployee(Employee newEmpObject) {
		Session sessionObject = null;
		try {
			sessionObject = HibernateSessionFactory.getSession();
			sessionObject.getTransaction().begin();
			sessionObject.update(newEmpObject);
			sessionObject.getTransaction().commit();
		} catch (Exception ex) {
			sessionObject.getTransaction().rollback();
			throw new RuntimeException(ex.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sk.emp.repository.EmployeeRepository#getEmployee(int)
	 */
	@Override
	public Employee getEmployee(int empID) {
		try {
			return (Employee) HibernateSessionFactory.getSession().get(Employee.class, empID);
		} catch (Exception empNotfoundError) {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sk.emp.repository.EmployeeRepository#deleteEmployee(int)
	 */
	@Override
	public void deleteEmployee(int empID) {
		Transaction txnObject = null;
		try {
			Session sessionObject = HibernateSessionFactory.getSession();
			txnObject = sessionObject.beginTransaction();
			Employee empObject = (Employee) sessionObject.get(Employee.class, empID);
			sessionObject.delete(empObject);
			txnObject.commit();
		} catch (Exception ex) {
			txnObject.rollback();
			throw new RuntimeException(ex.getMessage());
		}
	}
}//class
