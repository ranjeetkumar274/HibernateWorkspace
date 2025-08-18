package com.ashu.dao;

import com.ashu.entity.Student;

public interface StudentDAO {
	default void saveStudent(Student student) {
		// Implementation to save student details in the database
	}
	
	Student loadStudent(int sid);
}
