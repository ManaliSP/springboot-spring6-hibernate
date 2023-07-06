package com.springtutorial.springrestemployeecrud.dao;

import com.springtutorial.springrestemployeecrud.Entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
