package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

    public Employee() {

    }

    public Employee(final int businessentityid, final String loginid, final String jobtitle) {
        this.businessentityid = businessentityid;
        this.loginid = loginid;
        this.jobtitle = jobtitle;
    }
    @Id
    private int businessentityid;
    @Column
    private String loginid;
    @Column
    private String jobtitle;



}
