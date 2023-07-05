package com.springtutorial.springrestservices.rest;

import com.springtutorial.springrestservices.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    // define @postConstruct to load the student data ...only once
    @PostConstruct
    public void loadStudentData(){

        students = new ArrayList<>();
        students.add(new Student("Daffy", "Duck"));
        students.add(new Student("Mary", "Gold"));
        students.add(new Student("Mario", "Rossi"));

    }

    // define an endpoint for "/students"
    @GetMapping("/students")
    public List<Student> getStudents(){

        return students;
    }

    // define endoint for "/students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        //just index into the list...keep it simple for now

        return students.get(studentId);
    }
}
