package com.example.demo.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demo.model.EmployeePayHistory;
import com.example.demo.service.EmployeePayHistoryService;
import org.springframework.stereotype.Service;

@Service
public class EmployeePayHistoryQueryResolver implements GraphQLQueryResolver {
    private final EmployeePayHistoryService employeePayHistoryService;

    public EmployeePayHistoryQueryResolver(EmployeePayHistoryService employeePayHistoryService) {
        this.employeePayHistoryService = employeePayHistoryService;
    }

    public EmployeePayHistory employeepayhistory(final int id) {
        return employeePayHistoryService.getEmployeePayHistory(id);
    }
}
