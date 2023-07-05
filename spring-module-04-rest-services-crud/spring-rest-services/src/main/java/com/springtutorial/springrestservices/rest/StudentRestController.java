package com.springtutorial.springrestservices.rest;

import com.springtutorial.springrestservices.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

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

    // define endpoint for "/students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        // check the studentId against list size
        if(studentId >= students.size() ||  studentId < 0){
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return students.get(studentId);
    }
}