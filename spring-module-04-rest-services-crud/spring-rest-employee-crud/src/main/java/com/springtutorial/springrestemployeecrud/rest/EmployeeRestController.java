package com.springtutorial.springrestemployeecrud.rest;

import com.springtutorial.springrestemployeecrud.Entity.Employee;
import com.springtutorial.springrestemployeecrud.dao.EmployeeDAO;
import com.springtutorial.springrestemployeecrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    // add mapping for GET /employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){

        Employee employee = employeeService.findById(employeeId);

        if(employee == null){
            throw  new RuntimeException("Employee id not fount : " + employeeId);
        }

        return employee;
    }

    // add mapping for POST /employees - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){

        // also in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        employee.setId(0);

        return employeeService.save(employee);
    }

    // add mapping for PUT /employees - update existing employee

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){

        return employeeService.save(employee);
    }


    // add mapping for DELETE /employees/{employeeId} - delete existing employee

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee employee = employeeService.findById(employeeId);

        // throw exception if null

        if(employee == null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;
    }
}
