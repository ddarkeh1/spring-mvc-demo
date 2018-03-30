package com.ddarkeh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ddarkeh.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create a session

		Session session = factory.getCurrentSession();

		try {			
			// create a student object
			System.out.println("Creating 3 student object..");
			Student tempStudent1 = new Student("Chris", "Leese", "chris.leese@ingg.com");
			Student tempStudent2 = new Student("Huw", "Hughes", "huw.hughes@ingg.com");
			Student tempStudent3 = new Student("Oaf", "Davies", "oaf.davies@ingg.com");
			
			// start a transaction
			session.beginTransaction();

			// Save the student object
			System.out.println("Passing Student object to session save");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			// commit the db transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}

	}

}
