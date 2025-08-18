package com.ashu.client;

import com.ashu.dao.StudentDAO;
import com.ashu.dao.impl.StudentDAOImpl;
import com.ashu.entity.Student;

public class Tester {
	public static void main(String[] args) {
		
		StudentDAO dao = new StudentDAOImpl();
		
		Student student = new Student();
		student.setSid(11);
		student.setSname("Ram");
		student.setGender("Male");
		student.setMarks(70);
		
		dao.saveStudent(student);
	}
}
