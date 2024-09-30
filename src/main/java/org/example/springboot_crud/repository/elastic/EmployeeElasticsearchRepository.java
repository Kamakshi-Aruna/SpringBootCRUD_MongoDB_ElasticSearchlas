package org.example.springboot_crud.repository.elastic;

import org.example.springboot_crud.model.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EmployeeElasticsearchRepository extends ElasticsearchRepository<Employee, Integer> {
}
