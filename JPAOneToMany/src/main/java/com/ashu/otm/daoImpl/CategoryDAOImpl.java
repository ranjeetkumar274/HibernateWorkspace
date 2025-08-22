package com.ashu.otm.daoImpl;

import com.ashu.otm.dao.CategoryDAO;
import com.ashu.otm.entities.CategoryEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CategoryDAOImpl implements CategoryDAO{
	
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-pu");
	@Override
	public void saveCategory(CategoryEntity category) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			em.persist(category);
			t.commit();
			System.out.println("Category saved successfully!");
		}catch(Exception e) {
			t.rollback();
			e.printStackTrace();
			System.out.println("Error saving category: " + e.getMessage());
		}finally {
			em.close();
		}
	}

	@Override
	public CategoryEntity fetchCategory(Integer catgId) {
		EntityManager em = factory.createEntityManager();
		
			CategoryEntity category = em.find(CategoryEntity.class, catgId);
			return category;
	}

	@Override
	public void removeCategory(Integer catgId) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			CategoryEntity category = em.find(CategoryEntity.class, catgId);
			em.remove(category);
			t.commit();
			System.out.println("Category removed successfully!");
		}catch(Exception e) {
			t.rollback();
			e.printStackTrace();
			System.out.println("Error removing category: " + e.getMessage());
		} finally {
			em.close();
		}	
	}
	
	
}
