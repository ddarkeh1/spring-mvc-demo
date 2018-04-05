package com.ddarkeh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ddarkeh.hibernate.demo.entity.Instructor;
import com.ddarkeh.hibernate.demo.entity.InstructorDetail;
import com.ddarkeh.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create a session
		
		Session session = factory.getCurrentSession();
		
		try {			

			
			// start a transaction
			session.beginTransaction();
			
			// get
			
			int theId = 1;
			Instructor tempInstructor =
					session.get(Instructor.class, theId);
			// delete
			if (tempInstructor != null) {
				session.delete(tempInstructor);
			}
			
			// commit the db transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

}
