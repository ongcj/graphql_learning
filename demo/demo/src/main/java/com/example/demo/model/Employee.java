package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    public Employee() {

    }

    public Employee(final int businessentityid,
                    final String loginid,
                    final String jobtitle,
                    final EmployeePayHistory payhistory) {
        this.businessentityid = businessentityid;
        this.loginid = loginid;
        this.jobtitle = jobtitle;
        this.payhistory = payhistory;
    }
    @Id
    private int businessentityid;
    @Column
    private String loginid;
    @Column
    private String jobtitle;
    @OneToOne
    @JoinColumn(name = "businessentityid")
    private EmployeePayHistory payhistory;


}
