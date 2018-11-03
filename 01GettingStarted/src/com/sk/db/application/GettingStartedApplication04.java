package com.sk.db.application;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sk.firstapp.Employee;

public class GettingStartedApplication04 {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.addJar(new File(
				"G:\\ApplicationWorkbook\\hibernate_workspace\\GettingStarted01\\src\\config04\\configbundle.jar"));

		SessionFactory sf = configuration.buildSessionFactory();
		Session session = sf.openSession();

		Employee emp01 = (Employee) session.get(Employee.class, 7839);
		System.out.println(emp01);
	}
}
