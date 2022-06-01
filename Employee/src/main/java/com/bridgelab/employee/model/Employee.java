package com.bridgelab.employee.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String gender;
    @OneToMany(targetEntity = Department.class,cascade = CascadeType.ALL)
    public List<Department> department;
    private int salary;
    private int startDay;
    private int startMonth;
    private int startYear;
}
