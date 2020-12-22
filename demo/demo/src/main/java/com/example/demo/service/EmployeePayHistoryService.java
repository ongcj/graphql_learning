package com.example.demo.service;

import com.example.demo.model.EmployeePayHistory;
import com.example.demo.repository.EmployeePayHistoryRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeePayHistoryService {
    private final EmployeePayHistoryRepository repository;

    public EmployeePayHistoryService(EmployeePayHistoryRepository repository) {
        this.repository = repository;
    }

    public EmployeePayHistory getEmployeePayHistory(int id) {
        return repository.findById(id).orElse(null);
    }
}
