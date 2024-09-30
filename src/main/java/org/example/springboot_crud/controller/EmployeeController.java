package org.example.springboot_crud.controller;

import org.example.springboot_crud.model.Employee;
import org.example.springboot_crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

//    Add the Employee Details in MongoDB and ElasticSearch
    @PostMapping
    public String saveEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return "Data Inserted Successfully!!";
    }

//    Get the Employee Details from MongoDB using id
    @GetMapping("/mongo/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable int id) {
       return employeeService.getEmployeeByIdMongo(id);
    }

//    Get the Employee Details from Elastic using id
    @GetMapping("/elastic/{id}")
    public Optional<Employee> getEmployeeByIdElastic(@PathVariable int id) {
        return employeeService.getEmployeeByIdElastic(id);
    }

//    Get all the Employee Details using MongoDB
    @GetMapping("/mongo")
    public List<Employee> getAllEmployeesFromMongoDB() {
       return  employeeService.getAllEmployeesFromMongo();
    }

//    Get all the Employee Details using Elastic
    @GetMapping("/elastic")
    public Iterable<Employee> getAllEmployeesFromElastic() {
       return employeeService.getAllEmployeesFromElastic();
    }

//    Delete the Employee Details from both MongoDB & ElasticSearch using id
    @DeleteMapping("/delete/{id}")
    public String deleteEmployeeById(@PathVariable int id) {
        employeeService.deleteEmployeeById(id);
        return "Data Deleted Successfully!!";
    }

//    Delete the Employee Details in both MongoDB & ElasticSearch
    @DeleteMapping
    public String deleteEmployees() {
        employeeService.deleteEmployees();
        return "Data Deleted Successfully!!";
    }

//    Update the Employee Details in MongoDB
    @PutMapping("/mongo")
    public String updateEmployeeFromMongo(@RequestBody Employee employee) {
        return employeeService.updateEmployeeMongo(employee);
    }

//    Update the Employee Details in ElasticSearch
    @PutMapping("/elastic")
    public String updateEmployeesFromElastic(@RequestBody Employee employee) {
        return employeeService.updateEmployeeElastic(employee);
    }

}
