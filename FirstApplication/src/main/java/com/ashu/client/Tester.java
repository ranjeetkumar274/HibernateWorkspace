package com.ashu.client;

import com.ashu.dao.StudentDAO;
import com.ashu.dao.impl.StudentDAOImpl;
import com.ashu.entity.Student;

public class Tester {
	public static void main(String[] args) {
		
		StudentDAO dao = new StudentDAOImpl();
		
//		Student student = new Student();
//		student.setSid(12);
//		student.setSname("Ashu");
//		student.setGender("Male");
//		student.setMarks(90);
//		
//		dao.saveStudent(student);
		
		
		Student stud = dao.loadStudent(12);
		System.out.println();
		System.out.println(stud);
	}
}
