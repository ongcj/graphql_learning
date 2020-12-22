package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employeepayhistory")
public class EmployeePayHistory {

    public EmployeePayHistory() {
    }

    public EmployeePayHistory(int businessentityid, LocalDate ratechangedate, double rate, int payfrequency) {
        this.businessentityid = businessentityid;
        this.ratechangedate = ratechangedate;
        this.rate = rate;
        this.payfrequency = payfrequency;
    }

    @Id
    private int businessentityid;
    @Column
    private LocalDate ratechangedate;
    @Column
    private double rate;
    @Column
    private int payfrequency;


}
