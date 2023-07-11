package com.springboot.advancedmappingcruddemo.dao;

import com.springboot.advancedmappingcruddemo.entity.Instructor;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);
}
