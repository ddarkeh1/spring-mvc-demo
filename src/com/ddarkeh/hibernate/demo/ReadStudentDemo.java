package com.ddarkeh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ddarkeh.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			Student tempStudent = new Student("Daffy", "Duck", "DaffyDuck@hotmail.com");
			
			// start a transaction
			session.beginTransaction();
			
			// Save the student object
			System.out.println("Passing Student object to session save");
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			// Read Code
			
			// find out the student's id: primary key
			System.out.println("Saved Studen. Generated id " + tempStudent.getId());
			
			// get a new session
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on id
			System.out.println("\nGetting student with id: " + tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get Complete: " + myStudent);
			// commit the transaction
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

}
