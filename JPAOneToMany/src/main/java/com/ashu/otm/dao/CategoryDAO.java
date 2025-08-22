package com.ashu.otm.dao;

import com.ashu.otm.entities.CategoryEntity;

public interface CategoryDAO {
	
	void saveCategory(CategoryEntity category);
	CategoryEntity fetchCategory(Integer catgId);
	void removeCategory(Integer catgId);
}
