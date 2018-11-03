package com.sk.db.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	private static SessionFactory factory;
	private static ThreadLocal<Session> currentThread;
	static {
		try {
			Configuration configuration = new Configuration();
			configuration.configure();

			factory = configuration.buildSessionFactory();
		} catch (Exception error) {
			error.printStackTrace();
			throw new RuntimeException(error.getMessage());
		}
		currentThread = new ThreadLocal<>();
	}// static-initializer

	public static SessionFactory getSessionFactory() {
		return factory;
	}

	public static Session getSession() {
		Session ssn = currentThread.get();
		if (ssn != null) {
			return ssn;
		} else {
			System.out.println("session creation");
			ssn = factory.openSession();
			currentThread.set(ssn);
			return ssn;
		}
	}
	
	public static void closeSession() {
		Session ssn=currentThread.get();
		if(ssn!=null)
		{
			ssn.close();
		}
	}
}
