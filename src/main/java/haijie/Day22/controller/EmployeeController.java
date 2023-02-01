package haijie.Day22.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import haijie.Day22.model.Employee;
import haijie.Day22.repository.EmployeeRepo;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    
    @Autowired
    EmployeeRepo employeeRepo;

    @GetMapping("/")
    public List<Employee> retrieveEmployees(){
        List<Employee> employees=employeeRepo.retrieveEmployeeList();

        if(employees.isEmpty()){
            return null;
        } else{
            return employees;
        }
    }

}
