package com.fil.springbasic.service;

import com.fil.springbasic.employee.Employee;
import com.fil.springbasic.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> fetchAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee findEmployeeById(Long id){
        return employeeRepository.findById(id).orElseThrow();
    }

    public  Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
}
