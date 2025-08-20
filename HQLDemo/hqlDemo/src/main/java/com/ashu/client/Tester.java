package com.ashu.client;

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
        department.setName("IT");
        departmentDAO.saveDepartment(department);  // Persist first so IDENTITY id is generated

        Employee employee = new Employee();
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setDepartment(department);        // Set FK relationship

        employeeDAO.saveEmployee(employee);
        System.out.println("Done. Dept id=" + department.getId() + ", Emp id=" + employee.getId());
    }
}