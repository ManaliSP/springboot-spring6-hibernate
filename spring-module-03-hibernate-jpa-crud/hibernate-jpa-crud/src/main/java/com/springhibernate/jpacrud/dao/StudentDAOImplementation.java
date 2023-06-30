package com.springhibernate.jpacrud.dao;

import com.springhibernate.jpacrud.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImplementation implements StudentDAO{

    // define fields for entity manager
    private EntityManager entityManager;

    // Inject entity manager using constructor injection
    @Autowired
    public StudentDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    // implement find by id method
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    // implement method to retrieve multiple objects
    @Override
    public List<Student> findAll() {

        // create query
        TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);

        // return query result
        return query.getResultList();
    }

    // implement method to find by last name
    @Override
    public List<Student> findByLastName(String lastName) {

        // create a query
        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);

        // set query parameters
        query.setParameter("theData", lastName);

        // return query results
        return query.getResultList();
    }
}
