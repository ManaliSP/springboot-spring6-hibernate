package com.springboot.advancedmappingcruddemo.dao;

import com.springboot.advancedmappingcruddemo.entity.Instructor;
import com.springboot.advancedmappingcruddemo.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);
}
