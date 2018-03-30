package com.ddarkeh.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ddarkeh.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create a session
		
		Session session = factory.getCurrentSession();
		
		try {			
			// start a transaction
			session.beginTransaction();
			
			// Query students
			
			
			List<Student> theStudents = session
										.createQuery("from Student").list();

			displayStudents(theStudents);
			
			// Query all sudents where x
			
			theStudents = session
						  .createQuery("from Student s where s.lastname='Duck'")
						  .getResultList();
			
			
			displayStudents(theStudents);
			
			// commit the db transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student student : theStudents) {
			System.out.println(student);
		}
	}

}
