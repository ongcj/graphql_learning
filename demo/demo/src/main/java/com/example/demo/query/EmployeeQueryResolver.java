package com.example.demo.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeQueryResolver implements GraphQLQueryResolver {
    private final EmployeeService employeeService;

    public EmployeeQueryResolver(final EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee employee(final int id) {
        return employeeService.getEmployee(id);
    }
}
