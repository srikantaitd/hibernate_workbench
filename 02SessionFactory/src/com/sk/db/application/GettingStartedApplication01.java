package com.sk.db.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sk.db.utility.HibernateSessionFactory;
import com.sk.firstapp.Employee;

public class GettingStartedApplication01 {

	public static void main(String[] args) {
		SessionFactory sf=HibernateSessionFactory.getSessionFactory();
		System.out.println(sf);
		Session session = sf.openSession();

		Employee emp01 = (Employee) session.get(Employee.class, 7839);
		System.out.println(emp01);
	
	}
}
