package uk.co.sheffieldwebprogrammer.springsearch.springsearchdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.sheffieldwebprogrammer.springsearch.springsearchdemo.model.Employee;
import uk.co.sheffieldwebprogrammer.springsearch.springsearchdemo.repository.EmployeeRepository;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public void get(){
        String name[] = new String[]{"John", "Paul", "Jane", "Mary", "Max"};
        long salaries[] = new long[]{20000l, 10000l};
        String cvs[] = new String[]{
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed JAVA nisi auctor, placerat diam ac, consectetur mi. Fusce aliquet id est id fringilla. Pellentesque commodo laoreet odio, nec malesuada libero. Pellentesque eget lacinia massa. Pellentesque scelerisque rutrum orci, vel ornare ligula gravida quis. Integer sapien augue, pulvinar nec tortor id, elementum euismod nunc. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Pellentesque vitae lorem efficitur, dignissim lectus vitae, egestas sapien. Integer finibus pulvinar urna, vitae congue lacus. Integer efficitur pretium justo, nec fringilla lorem elementum vitae. Cras pulvinar massa ut enim ultrices laoreet. Duis sed dolor pharetra, bibendum turpis eu, euismod nisi.",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed PHP nisi auctor, placerat diam ac, consectetur mi. Fusce aliquet id est id fringilla. Pellentesque commodo laoreet odio, nec malesuada libero. Pellentesque eget lacinia massa. Pellentesque scelerisque rutrum orci, vel ornare ligula gravida quis. Integer sapien augue, pulvinar nec tortor id, elementum euismod nunc. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Pellentesque vitae lorem efficitur, dignissim lectus vitae, egestas sapien. Integer finibus pulvinar urna, vitae congue lacus. Integer efficitur pretium justo, nec fringilla lorem elementum vitae. Cras pulvinar massa ut enim ultrices laoreet. Duis sed dolor pharetra, bibendum turpis eu, euismod nisi.",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed JAVASCRIPT nisi auctor, placerat diam ac, consectetur mi. Fusce aliquet id est id fringilla. Pellentesque commodo laoreet odio, nec malesuada libero. Pellentesque eget lacinia massa. Pellentesque scelerisque rutrum orci, vel ornare ligula gravida quis. Integer sapien augue, pulvinar nec tortor id, elementum euismod nunc. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Pellentesque vitae lorem efficitur, dignissim lectus vitae, egestas sapien. Integer finibus pulvinar urna, vitae congue lacus. Integer efficitur pretium justo, nec fringilla lorem elementum vitae. Cras pulvinar massa ut enim ultrices laoreet. Duis sed dolor pharetra, bibendum turpis eu, euismod nisi.",
        };
        for(int i=0; i<1000; i++){
            Employee employee = new Employee();
            employee.setName(name[ThreadLocalRandom.current().nextInt(0, name.length)]);
            employee.setSalary(salaries[ThreadLocalRandom.current().nextInt(0, salaries.length)]);
            employee.setCv(cvs[ThreadLocalRandom.current().nextInt(0, cvs.length)]);
            Employee savedEmployee = employeeRepository.save(employee);

        }

    }

    @RequestMapping("/all")
    @GetMapping
    public List<Employee> listAll() {
        return employeeRepository.findByCvContaining("JAVA");
    }

    @RequestMapping("/salary")
    @GetMapping
    public List<Employee> sal() {
        Sort sortBy = Sort.by(Sort.Order.asc("salary"));
        Pageable pageable = PageRequest.of(0,10, sortBy);
        return employeeRepository.findBySalary(10000l, pageable).getContent();
    }

    @RequestMapping("/pageemployee")
    @GetMapping
    public List<Employee> pageemp() {
        Sort sortBy = Sort.by(Sort.Order.asc("cv"));
        Pageable pageable = PageRequest.of(0,10, sortBy);
        return employeeRepository.findByCvContaining("JAVA", pageable).getContent();
    }


}
