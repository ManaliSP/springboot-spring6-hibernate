package com.springtutorial.springrestemployeecrud.dao;

import com.springtutorial.springrestemployeecrud.Entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImplementation implements EmployeeDAO{

    // define field for Entity manager
    private EntityManager entityManager;

    // set up constructor injection
    public EmployeeDAOJpaImplementation(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        // create a query
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);

        // execute a query and get result list
        List<Employee> employees = query.getResultList();

        // return the results
        return employees;
    }
}
