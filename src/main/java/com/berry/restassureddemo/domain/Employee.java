package com.berry.restassureddemo.domain;

import lombok.Getter;

@Getter
public class Employee {
  
  private String id;
  private String firstName;
  private String lastName;
  private double salary;
  
  public Employee() {}
  
  public Employee(String id, String fName, String lName, double sal) {
    this.id = id;
    this.firstName = fName;
    this.lastName = lName;
    this.salary = sal;
  }

}
