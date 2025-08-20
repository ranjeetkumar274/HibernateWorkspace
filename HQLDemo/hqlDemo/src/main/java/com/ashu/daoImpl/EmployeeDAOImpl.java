package com.ashu.daoImpl;

import java.util.List;

import org.hibernate.Query;
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

	@Override
	public List<Employee> getAllEmployees() {
		Session session = factory.openSession();
		List<Employee> employees = session.createQuery("from Employee", Employee.class).list();
		return employees;
	}

	@Override
	public Employee loadEmployee(int id) {
		Session session = factory.openSession();
		Query<Employee> query = (Query<Employee>) session.createQuery("from Employee e where e.id = ?");
		query.setParameter(1, id);
		Employee emp = query.uniqueResult();
		session.close();
		return emp;
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Employee> getEmployeesByDepartmentId(int departmentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllEmployeesByDepartmentId(int departmentId) {
		// TODO Auto-generated method stub
		
	}
	
}
