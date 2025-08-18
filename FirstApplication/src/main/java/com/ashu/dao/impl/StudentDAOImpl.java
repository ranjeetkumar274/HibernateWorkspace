package com.ashu.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import com.ashu.dao.StudentDAO;
import com.ashu.entity.Student;

public class StudentDAOImpl implements StudentDAO {

	SessionFactory factory;
	
	public StudentDAOImpl() {
		
		ServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
		
		factory = metadata.getSessionFactoryBuilder().build();
		
	}
	
	@Override
	public void saveStudent(Student student) {
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		try {
			session.persist(student); // Use persist instead of save for JPA entities
			System.out.println("Session object is persisted in Database.");
			t.commit();
		}catch(Exception e) {
			t.rollback();
			System.out.println("Issue in persisting.");
			e.printStackTrace();
		}
		finally {
			session.close();
			// factory.close(); // Do not close factory here; it should be closed once for the whole application, not per operation
		}
	}
}