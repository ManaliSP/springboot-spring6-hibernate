package com.springtutorial.springrestemployeecrud.rest;

import com.springtutorial.springrestemployeecrud.Entity.Employee;
import com.springtutorial.springrestemployeecrud.dao.EmployeeDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeDAO employeeDAO;

    // Quick and dirty : inject employee dao
    public EmployeeRestController(EmployeeDAO theEmployeeDAO){
        employeeDAO = theEmployeeDAO;
    }

    // expose "/employees" and return all employees
    @GetMapping("employees")
    public List<Employee> getAllEmployees(){
        return employeeDAO.findAll();
    }
}
