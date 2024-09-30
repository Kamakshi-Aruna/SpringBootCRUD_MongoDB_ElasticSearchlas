package org.example.springboot_crud.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;


@Data
@Document(indexName = "employee")
@org.springframework.data.mongodb.core.mapping.Document(collection = "employee")
public class Employee {
    @Id
    private int id;
    private String name;
    private String department;
    private double salary;
}
