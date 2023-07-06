package com.springtutorial.springrestemployeecrud.service;

import com.springtutorial.springrestemployeecrud.Entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
