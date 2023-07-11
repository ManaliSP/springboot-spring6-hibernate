package com.springboot.advancedmappingcruddemo.dao;

import com.springboot.advancedmappingcruddemo.entity.Course;
import com.springboot.advancedmappingcruddemo.entity.Instructor;
import com.springboot.advancedmappingcruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO{

    // define field for entity manager
    private EntityManager entityManager;

    // Inject entity manager using constructor injection
    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {

        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {

        // retrieve instructor
        Instructor instructor = entityManager.find(Instructor.class, id);

        // delete instructor
        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {

        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {

        // retrieve instructor
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);

        // remove the associated object reference
        // break bi-directional link
        //
        instructorDetail.getInstructor().setInstructorDetail(null);

        // delete instructor
        entityManager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {

        // create a query
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :data", Course.class);

        query.setParameter("data", id);

        // execute query
        List<Course> courses = query.getResultList();

        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {

        // Create a query
        TypedQuery<Instructor> query = entityManager.createQuery("SELECT i from Instructor i " +
                        "JOIN FETCH i.courses " +
                        "JOIN FETCH i.instructorDetail" +
                        " where i.id = :data",
                Instructor.class);

        query.setParameter("data", id);

        // execute a query
        Instructor instructor = query.getSingleResult();

        return instructor;
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseById(int id) {

        return entityManager.find(Course.class, id);
    }
}
