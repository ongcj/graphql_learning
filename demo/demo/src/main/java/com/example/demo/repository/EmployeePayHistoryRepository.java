package com.example.demo.repository;

import com.example.demo.model.EmployeePayHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePayHistoryRepository extends JpaRepository<EmployeePayHistory, Integer> {
}
