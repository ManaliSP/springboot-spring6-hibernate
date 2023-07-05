package com.springtutorial.springrestservices.rest;

import com.springtutorial.springrestservices.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    // define an endpoint for "/students"
    @GetMapping("/students")
    public List<Student> getStudents(){

        List<Student> students = new ArrayList<>();
        students.add(new Student("Daffy", "Duck"));
        students.add(new Student("Mary", "Gold"));
        students.add(new Student("Mario", "Rossi"));

        return students;
    }
}
