package com.ashu.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ashu.dao.StudentDAO;
import com.ashu.entity.Student;

public class StudentDAOImpl implements StudentDAO{
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
	
	@Override
	public void saveStudent(Student student) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		try {
			et.begin();
			em.persist(student);
			et.commit();
		}catch(Exception e) {
			et.rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
	}

//	@Override
////	public Student getStudent() {
////		int id = student.getId();
////		EntityManager em = emf.createEntityManager();
////		Student stud = em.find(Student.class, id);
////		return stud;
////	}	
}
