package com.sk.db.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sk.db.utility.HibernateSessionFactory;
import com.sk.firstapp.Employee;

public class GettingStartedApplication01 {

	public static void main(String[] args) {
		SessionFactory sf=HibernateSessionFactory.getSessionFactory();
		System.out.println(sf);
		Session session = HibernateSessionFactory.getSession();
		System.out.println(session);

		System.out.println("same thread: "+ HibernateSessionFactory.getSession().hashCode());
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thred1:"+HibernateSessionFactory.getSession().hashCode());
				HibernateSessionFactory.closeSession();
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thred2:"+HibernateSessionFactory.getSession().hashCode());
				HibernateSessionFactory.closeSession();
			}
		}).start();
		
		Employee emp01 = (Employee) session.get(Employee.class, 7839);
		System.out.println(emp01);
		
		HibernateSessionFactory.closeSession();
		
	}
}
