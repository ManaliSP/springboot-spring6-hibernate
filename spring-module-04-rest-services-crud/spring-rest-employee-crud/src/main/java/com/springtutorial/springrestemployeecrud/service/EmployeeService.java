package com.springtutorial.springrestemployeecrud.service;

import com.springtutorial.springrestemployeecrud.Entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
}
