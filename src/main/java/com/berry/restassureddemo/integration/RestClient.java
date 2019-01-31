package com.berry.restassureddemo.integration;

import java.util.Arrays;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import lombok.SneakyThrows;

@Configuration
public class RestClient {

  @Autowired
  private RestTemplate restTemplate;

  @SneakyThrows
  public ResponseEntity<String> getFormulaOneData() {
    
    final String url = "http://ergast.com/api/f1/2008.json";
    
    JSONObject jo = new JSONObject();
    jo.put("Method", "GET");
    jo.put("Request-URI", "http://ergast.com/api/f1/2008.json");
    
    //final String url2 = HTTP.toString(jo);

    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

    ResponseEntity<String> response =
        restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

    return response;
  }

}
