package com.sk.db.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sk.db.utility.HibernateSessionFactory;
import com.sk.firstapp.Employee;

public class SingleSession02 {

	public static void main(String[] args) {
		SessionFactory sf=HibernateSessionFactory.getSessionFactory();
		System.out.println(sf);
		Session session = sf.getCurrentSession();
		System.out.println(session);

		System.out.println("same thread: "+ sf.getCurrentSession().hashCode());
		System.out.println("same thread: "+ sf.getCurrentSession().hashCode());
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thred1:"+sf.getCurrentSession().hashCode());
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thred2:"+sf.getCurrentSession().hashCode());
			}
		}).start();
		
		session.getTransaction().begin();
		Employee emp01 = (Employee) session.get(Employee.class, 7839);
		session.getTransaction().commit();
		System.out.println(emp01);
	}
}
