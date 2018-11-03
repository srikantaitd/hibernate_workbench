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
			sessionObject = HibernateSessionFactory.getSessionFactory().getCurrentSession();
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
			sessionObject = HibernateSessionFactory.getSessionFactory().getCurrentSession();
			sessionObject.getTransaction().begin();
			sessionObject.update(newEmpObject);
			sessionObject.getTransaction().commit();
		} catch (Exception ex) {
			sessionObject.getTransaction().rollback();
			ex.printStackTrace();
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
		Session sessionObject = null;
		try {
			Employee employee = null;
			sessionObject = HibernateSessionFactory.getSessionFactory().getCurrentSession();
			sessionObject.getTransaction().begin();
			employee = (Employee) sessionObject.get(Employee.class,
					empID);
			sessionObject.getTransaction().commit();
			
			return employee;
		} catch (Exception ex) {
			sessionObject.getTransaction().rollback();
			ex.printStackTrace();
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
		Session sessionObject = null;
		try {
			sessionObject = HibernateSessionFactory.getSessionFactory().getCurrentSession();
			sessionObject.getTransaction().begin();
			Employee empObject = (Employee) sessionObject.get(Employee.class, empID);
			sessionObject.delete(empObject);
			sessionObject.getTransaction().commit();
		} catch (Exception ex) {
			sessionObject.getTransaction().rollback();
			ex.printStackTrace();
			throw new RuntimeException(ex.getMessage());
		}
	}
}// class
