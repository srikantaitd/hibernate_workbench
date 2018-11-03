package com.sk.db.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	private static SessionFactory factory = null;

	static {
		try {
			Configuration configuration = new Configuration();
			configuration.configure();

			factory = configuration.buildSessionFactory();
		} catch (Exception error) {
			error.printStackTrace();
			throw new RuntimeException(error.getMessage());
		}
	}// static-initializer

	public static SessionFactory getSessionFactory() {
		return factory;
	}
}
