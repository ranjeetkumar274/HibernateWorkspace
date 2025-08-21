package com.ashu.dao;

import java.util.List;

import com.ashu.entity.Employee;

public interface EmployeeDAO {
	
	void saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee loadEmployee(int id);
	void updateEmployee(Employee employee);
	void deleteEmployee(int id);
	
	
}
