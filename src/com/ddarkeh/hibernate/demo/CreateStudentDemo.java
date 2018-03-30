package com.ddarkeh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ddarkeh.hibernate.demo.entity.Student;

public class CreateStudentDemo {

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
			System.out.println("Creating a new student object..");
			Student tempStudent = new Student("Steve", "Mitchell", "steavis313@hotmail.com");
			
			// start a transaction
			session.beginTransaction();
			
			// Save the student object
			System.out.println("Passing Student object to session save");
			session.save(tempStudent);
			
			// commit the db transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

}
