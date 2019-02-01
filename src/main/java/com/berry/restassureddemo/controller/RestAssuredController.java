package com.berry.restassureddemo.controller;

import java.io.File;
import java.nio.file.Files;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.berry.restassureddemo.dao.EmployeeDao;
import com.berry.restassureddemo.domain.Employee;
import com.berry.restassureddemo.domain.ResponseMessage;
import com.berry.restassureddemo.integration.RestClient;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;

@RestController
@RequestMapping(path = "/api")
public class RestAssuredController {

  @Autowired private RestClient restClient;
  @Autowired ObjectMapper objectMapper;
  
  @Autowired private EmployeeDao employeeDao;

  @GetMapping(path = "/test")
  public String test() {
    return "hello";
  }


  @GetMapping(path="/f1/circuits")  
  public ResponseEntity<String> getFormulaOne2018() {
    JSONObject jsonObj = new JSONObject();
    return restClient.getFormulaOneData();
  }
  
  @GetMapping(path="/test2")
  @SneakyThrows
  public ResponseMessage test2() {
//    String fileName = "employee.txt";
//    ClassLoader classLoader = this.getClass().getClassLoader();
//
//    File file = new File(classLoader.getResource(fileName).getFile());
//     
//    //File is found
//    System.out.println("File Found : " + file.exists());
//     
//    //Read File Content
//    String content = new String(Files.readAllBytes(file.toPath()));
//    System.out.println(content);
//    JSONObject jsonObject = new JSONObject(content);
    
    return new ResponseMessage("SUCCESS", "200");
  }
  
  @GetMapping(path="/test3/{appId}")
  public ResponseMessage test3(@PathVariable String appId, @RequestParam String code) {
    
    return new ResponseMessage("FAILURE", "417");
  }
  
  @PostMapping(path="/employee")
  public ResponseMessage createEmployee(String employee) {
    //employeeDao.addEmployee(employee);
    //System.out.println(employeeDao.getEmployees());

    return new ResponseMessage(HttpStatus.CREATED.name(),
        Integer.toString(HttpStatus.CREATED.value()));
  }

}
