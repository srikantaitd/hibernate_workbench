package com.sk.db.application;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sk.firstapp.Employee;

public class GettingStartedApplication07 {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.setProperty("hibernate.connection.driver_class","oracle.jdbc.driver.OracleDriver");
		configuration.setProperty("hibernate.connection.url","jdbc:oracle:thin:@localhost:1521/orcl");
		configuration.setProperty("hibernate.connection.username","SCOTT");
		configuration.setProperty("hibernate.connection.password","tiger");
		configuration.setProperty("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
		configuration.addResource("config07/employee-mapping.hbm.xml");
		
		SessionFactory sf = configuration.buildSessionFactory();
		Session session = sf.openSession();

		Employee emp01 = (Employee) session.get(Employee.class, 7839);
		System.out.println(emp01);
	}
}
