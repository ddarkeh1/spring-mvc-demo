package com.ddarkeh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ddarkeh.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			
			session.beginTransaction();
			
			Student tempStudent = session.get(Student.class, studentId);
			
			
			System.out.println("Deleting student: " + tempStudent);
			session.delete(tempStudent);
			
			session.createQuery("delete from Student where id=2").executeUpdate();
			// commit the transaction
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

}
