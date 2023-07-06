package com.springtutorial.employee.crud.springdatarest.dao;


import com.springtutorial.employee.crud.springdatarest.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!
}
