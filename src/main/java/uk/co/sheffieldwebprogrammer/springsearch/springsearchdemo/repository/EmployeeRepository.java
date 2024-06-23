package uk.co.sheffieldwebprogrammer.springsearch.springsearchdemo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import uk.co.sheffieldwebprogrammer.springsearch.springsearchdemo.model.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends ElasticsearchRepository<Employee, String> {

    Page<Employee> findByCvContaining(String name, Pageable pageable);

    List<Employee> findByCvContaining(String name);

    @Query("{\"match\": {\"salary\": {\"query\": \"?0\"}}}")
    Page<Employee> findBySalary(Long salary, Pageable pageable);

}