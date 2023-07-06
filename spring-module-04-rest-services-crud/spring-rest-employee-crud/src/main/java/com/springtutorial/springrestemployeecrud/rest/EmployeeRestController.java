package com.springtutorial.springrestemployeecrud.rest;

import com.springtutorial.springrestemployeecrud.Entity.Employee;
import com.springtutorial.springrestemployeecrud.dao.EmployeeDAO;
import com.springtutorial.springrestemployeecrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    // inject employee service (Use constructor injection)
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    // expose "/employees" and return all employees
    @GetMapping("employees")
    public List<Employee> getAllEmployees(){
        return employeeService.findAll();
    }



    // Implementation using only DAO

//    private EmployeeDAO employeeDAO;

    // Quick and dirty : inject employee dao (Use constructor injection)
//    @Autowired
//    public EmployeeRestController(EmployeeDAO theEmployeeDAO){
//        employeeDAO = theEmployeeDAO;
//    }

    // expose "/employees" and return all employees

//    @GetMapping("employees")
//    public List<Employee> getAllEmployees(){
//        return employeeDAO.findAll();
//    }
}
