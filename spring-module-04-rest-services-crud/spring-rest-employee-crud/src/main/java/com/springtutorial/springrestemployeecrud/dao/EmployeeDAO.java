package com.springtutorial.springrestemployeecrud.dao;

import com.springtutorial.springrestemployeecrud.Entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
