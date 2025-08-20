package com.ashu.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import com.ashu.dao.EmployeeDAO;
import com.ashu.entity.Employee;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	SessionFactory factory;
	
public EmployeeDAOImpl() {
		
		ServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
		
		factory = metadata.getSessionFactoryBuilder().build();
		
	}

	@Override
	public void saveEmployee(Employee employee) {
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.persist(employee); 
			System.out.println("Session object is persisted in Database.");
			t.commit();
		} catch(Exception e) {
			t.rollback();
			System.out.println("Issue in persisting.");
			e.printStackTrace();
		} finally {
			session.close();
		}
		System.out.println("Employee saved: " + employee.getFirstName()+ " " + employee.getLastName());
	}
	
}
