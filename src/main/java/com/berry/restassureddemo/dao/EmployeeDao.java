package com.berry.restassureddemo.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.berry.restassureddemo.domain.Employee;

@Service
public class EmployeeDao {
  
  private Map<String, Employee> records = new HashMap<>();
  
  public void addEmployee(Employee emp) {
    records.put(emp.getId(), emp);
  }
  
  public List<Employee> getEmployees() {
    return Collections.unmodifiableList((List<Employee>) records.values());
  }

}
