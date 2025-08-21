package com.ashu.client;

import java.util.Scanner;

import com.ashu.dao.DepartmentDAO;
import com.ashu.dao.EmployeeDAO;
import com.ashu.daoImpl.DepartmentDAOImpl;
import com.ashu.daoImpl.EmployeeDAOImpl;
import com.ashu.entity.Department;
import com.ashu.entity.Employee;

public class Tester {
    public static void main(String[] args) {

        DepartmentDAO departmentDAO = new DepartmentDAOImpl();
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

        Department department = new Department();
        Employee employee = new Employee();
        
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        
        
        	System.out.println("\n===== MENU =====");
            System.out.println("1. Insert Employee");
            System.out.println("2. Get All Employees");
            System.out.println("3. Get Employee by ID");
            System.out.println("4. Update Employee witn Id");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch(choice) {
           
            case 1:
        		System.out.print("Enter First Name: ");
				employee.setFirstName(sc.next());
				System.out.print("Enter Last Name: ");
				employee.setLastName(sc.next());
				
				
				System.out.print("Enter Department ID: ");
				Long deptId = sc.nextLong();

				// Load from DB
				Department dept = departmentDAO.loadDepartment(deptId);

				if (dept != null) {
				    employee.setDepartment(dept);
				    employeeDAO.saveEmployee(employee);
				    System.out.println("Employee saved successfully with department: " + dept.getName());
				} else {
				    System.out.println("Department with ID " + deptId + " does not exist. Please create it first.");
				}
				break;
				
            case 2:
				System.out.println("All Employees:");
				for (Employee emp : employeeDAO.getAllEmployees()) {
					System.out.println(emp.getId() + " " + emp.getFirstName() + " " + emp.getLastName());
				}
				break;
				
			case 3:
				System.out.print("Enter Employee ID to load: ");
				int empId = sc.nextInt();
				Employee loadedEmployee = employeeDAO.loadEmployee(empId);
				if (loadedEmployee != null) {
					System.out.println("Loaded Employee: " + loadedEmployee.getFirstName() + " " + loadedEmployee.getLastName());
				} else {
					System.out.println("Employee not found.");
				}
				break;
				
  			case 4:
				System.out.print("Enter Employee ID to update: ");
				int updateEmpId = sc.nextInt();
				Employee empToUpdate = employeeDAO.loadEmployee(updateEmpId);
				if (empToUpdate != null) {
					System.out.print("Enter new First Name: ");
					empToUpdate.setFirstName(sc.next());
					System.out.print("Enter new Last Name: ");
					empToUpdate.setLastName(sc.next());
					employeeDAO.updateEmployee(empToUpdate);
					System.out.println("Employee updated successfully.");
				} else {
					System.out.println("Employee not found.");
				}
				break;
				
  			case 5:
				System.out.print("Enter Employee ID to delete: ");
				int deleteEmpId = sc.nextInt();
				employeeDAO.deleteEmployee(deleteEmpId);
				System.out.println("Employee deleted successfully.");
				break;
				
			case 6:
				System.out.println("Exiting...");
				sc.close();
				return;
		}
    }
}