package uk.co.sheffieldwebprogrammer.springsearch.springsearchdemo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "employees", createIndex = true)
public class Employee {

    @Id
    private String employeeId;

    @Field(type = FieldType.Text, name = "name")
    private String name;

    @Field(type = FieldType.Long, name = "salary")
    private long salary;

    @Field(type = FieldType.Text, name = "cv")
    private String cv;

    // setters and getters
}