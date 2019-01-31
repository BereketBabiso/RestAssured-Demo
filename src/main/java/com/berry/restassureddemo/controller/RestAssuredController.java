package com.berry.restassureddemo.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.berry.restassureddemo.domain.ResponseMessage;
import com.berry.restassureddemo.integration.RestClient;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(path = "/api")
public class RestAssuredController {

  @Autowired private RestClient restClient;
  @Autowired ObjectMapper objectMapper;

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
  public ResponseMessage test2() {
    return new ResponseMessage("SUCCESS", "200");
  }
  
  @GetMapping(path="/test3/{appId}")
  public ResponseMessage test3(@PathVariable String appId, @RequestParam String code) {
    return new ResponseMessage("FAILURE", "417");
  }

}
