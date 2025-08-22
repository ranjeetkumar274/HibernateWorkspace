package com.ashu.otm.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;

import com.ashu.otm.dao.CategoryDAO;
import com.ashu.otm.daoImpl.CategoryDAOImpl;
import com.ashu.otm.entities.CategoryEntity;
import com.ashu.otm.entities.ProductEntity;

public class Tester {
	
	private static byte[] loadImage(String path) throws Exception {
	    File file = new File(path);
	    try (FileInputStream fis = new FileInputStream(file)) {
	        byte[] imageBytes = new byte[(int) file.length()];
	        fis.read(imageBytes);
	        return imageBytes;
	    }
	}

	public static void main(String[] args) throws Exception {
		
		CategoryDAO categoryDAO = new CategoryDAOImpl();
		
		// Test saving a category
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setCatgId(1401);
		categoryEntity.setCatgName("Electronics");
		
		
        // Test saving a product1 with an image
		ProductEntity product1 = new ProductEntity();
		product1.setProdId(220189);
		product1.setProdName("Smartphone");
		product1.setProdImage(loadImage("C:\\Users\\ashuy\\Desktop\\Books\\HibernatWorkspace\\testImages\\smartphone1.jpg"));
		
		// Test saving a product1 with an image
		ProductEntity product2 = new ProductEntity();
		product2.setProdId(220190);
		product2.setProdName("Tv");
		product2.setProdImage(loadImage("C:\\Users\\ashuy\\Desktop\\Books\\HibernatWorkspace\\testImages\\tv1.jpg"));
				
		// Test saving a product1 with an image
		ProductEntity product3 = new ProductEntity();
		product3.setProdId(220191);
		product3.setProdName("fridge");
		product3.setProdImage(loadImage("C:\\Users\\ashuy\\Desktop\\Books\\HibernatWorkspace\\testImages\\fridge1.jpg"));
		
		
		List <ProductEntity> lstOfProducts = Arrays.asList(product1, product2, product3);
		categoryEntity.setProducts(lstOfProducts);
		categoryDAO.saveCategory(categoryEntity);
		
		
	}
}
