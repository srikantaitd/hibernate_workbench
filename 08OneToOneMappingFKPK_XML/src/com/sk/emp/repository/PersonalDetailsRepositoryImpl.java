/**
 * 
 */
package com.sk.emp.repository;

import org.hibernate.Session;

import com.sk.db.utility.HibernateSessionFactory;
import com.sk.emp.domain.PersonalDetails;
import com.sk.emp.domain.PersonalDetails;

/**
 * @author srika
 *
 */
public class PersonalDetailsRepositoryImpl implements PersonalDetailsRepository {

	@Override
	public PersonalDetails getPDetails(int personalID) {
		Session sessionObject = null;
		try {
			PersonalDetails employee = null;
			sessionObject = HibernateSessionFactory.getSessionFactory().getCurrentSession();
			sessionObject.getTransaction().begin();
			employee = (PersonalDetails) sessionObject.get(PersonalDetails.class, personalID);
			sessionObject.getTransaction().commit();
			return employee;
		} catch (Exception ex) {
			sessionObject.getTransaction().rollback();
			ex.printStackTrace();
			return null;
		}
	}
}// class
