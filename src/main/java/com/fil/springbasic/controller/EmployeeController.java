package com.fil.springbasic.controller;

import com.fil.springbasic.employee.Employee;
import com.fil.springbasic.service.EmployeeService;
import org.apache.catalina.LifecycleState;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> allEmployees(){
        return employeeService.fetchAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee fetchEmployeeById(@PathVariable Long id){
        return employeeService.findEmployeeById(id);
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }
}
