package com.ddarkeh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ddarkeh.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create a session
		
		Session session = factory.getCurrentSession();
		
		try {			
			int studentId = 1;
			
			// start a transaction
			session.beginTransaction();
			
			// Retrieve student based on the id
			System.out.println("\nGetting student with id: " + studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating student..");
			myStudent.setFirstName("Scooby");
						
			// commit the db transaction
			session.getTransaction().commit();
			
			// New Update code
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// Update email for all student
			System.out.println("Update email");
			
			session.createQuery("update Student set email='foo@gmail.com'")
								.executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

}
