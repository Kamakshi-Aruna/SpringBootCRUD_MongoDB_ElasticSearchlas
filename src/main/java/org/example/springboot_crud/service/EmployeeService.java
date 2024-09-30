package org.example.springboot_crud.service;

import org.example.springboot_crud.model.Employee;
import org.example.springboot_crud.repository.elastic.EmployeeElasticsearchRepository;
import org.example.springboot_crud.repository.mongo.EmployeeMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMongoRepository employeeMongoRepository;
    @Autowired
    EmployeeElasticsearchRepository employeeElasticsearchRepository;

//   Add the Employee Details
    public void saveEmployee(Employee employee) {
//        save to MongoDB
        employeeMongoRepository.save(employee);
//        save to ElasticSearch
        employeeElasticsearchRepository.save(employee);
    }

//    Get the Employee Details from MongoDB using id
    public Optional<Employee> getEmployeeByIdMongo(int id) {
        return employeeMongoRepository.findById(id);
    }

//    Get the Employee Details from Elastic using id
    public Optional<Employee> getEmployeeByIdElastic(int id){
        return employeeElasticsearchRepository.findById(id);
    }

//    Get all the Employee Details from MongoDB
    public List<Employee> getAllEmployeesFromMongo() {
        return employeeMongoRepository.findAll();
    }


//    Get all the Employee Details from ElasticSearch
    public Iterable<Employee> getAllEmployeesFromElastic() {
       return  employeeElasticsearchRepository.findAll();
    }

//    Delete the Employee Details using id
    public void deleteEmployeeById(int id) {
        employeeMongoRepository.deleteById(id);
        employeeElasticsearchRepository.deleteById(id);
    }

//    Delete all the Employee Details
    public void deleteEmployees() {
        employeeMongoRepository.deleteAll();
        employeeElasticsearchRepository.deleteAll();
    }

//    Update the Employee Details in MongoDB
    public String updateEmployeeMongo(Employee employee) {
        Optional<Employee> op=employeeMongoRepository.findById(employee.getId());
        if(op.isPresent()){
            employee.setId(op.get().getId());
            employeeMongoRepository.save(employee);
            return "Data Updated Successfully!!";
        }else{
            return "No data found";
        }
    }

    //    Update the Employee Details in ElasticSearch
    public String updateEmployeeElastic(Employee employee) {
        Optional<Employee> op=employeeElasticsearchRepository.findById(employee.getId());
        if(op.isPresent()){
            employee.setId(op.get().getId());
            employeeElasticsearchRepository.save(employee);
            return "Data Updated Successfully!!";
        }else{
            return "No data found";
        }
    }

}
