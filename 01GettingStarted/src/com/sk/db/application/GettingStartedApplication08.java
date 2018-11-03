package com.sk.db.application;

import java.io.File;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sk.firstapp.Employee;

public class GettingStartedApplication08 {

	public static void main(String[] args) {
		Properties db_props=new Properties();
		db_props.setProperty("hibernate.connection.driver_class", "oracle.jdbc.driver.OracleDriver");
		db_props.setProperty("hibernate.connection.url", "jdbc:oracle:thin:@localhost:1521/orcl");
		db_props.setProperty("hibernate.connection.username", "SCOTT");
		db_props.setProperty("hibernate.connection.password", "tiger");
		db_props.setProperty("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
		
		Configuration configuration = new Configuration();
		configuration.addProperties(db_props);
		configuration.addResource("config07/employee-mapping.hbm.xml");
		
		SessionFactory sf = configuration.buildSessionFactory();
		Session session = sf.openSession();

		Employee emp01 = (Employee) session.get(Employee.class, 7839);
		System.out.println(emp01);
	}
}
