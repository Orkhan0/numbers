package com.company.test.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Integer employeeNumber;
    private String fullName;
    private String dept;
    private String speciality;
    private String structure;
//    @Email
    private String email;
}