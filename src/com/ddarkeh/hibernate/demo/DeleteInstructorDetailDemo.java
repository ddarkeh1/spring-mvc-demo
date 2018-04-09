package com.ddarkeh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ddarkeh.hibernate.demo.entity.Instructor;
import com.ddarkeh.hibernate.demo.entity.InstructorDetail;
import com.ddarkeh.hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo {

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
			int theId = 2;
			InstructorDetail tempInstructorDetail =
					session.get(InstructorDetail.class, theId);
			
			//print object
			
			System.out.println("tempInstDetails: " + tempInstructorDetail);
			
			//print associated
			
			System.out.println("associated: " + tempInstructorDetail.getInstructor());
					
			
			// delete
			System.out.println("Deleting associacted instructor: " + tempInstructorDetail);
			session.delete(tempInstructorDetail);
			
			
			// commit the db transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			} 
		catch (Exception exc) {
			exc.printStackTrace();
		} 
		finally {
			session.close();
			factory.close();
		}
	}

}
