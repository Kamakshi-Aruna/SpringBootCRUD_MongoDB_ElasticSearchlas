package org.example.springboot_crud.repository.mongo;

import org.example.springboot_crud.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeMongoRepository extends MongoRepository<Employee, Integer> {
}
