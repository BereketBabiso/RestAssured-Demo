package com.berry.restassureddemo.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseMessage {

  private String status;
  private String httpStatus;
  
  public ResponseMessage() {}
  
  public ResponseMessage(String status, String httpStatus) {
    this.status = status;
    this.httpStatus = httpStatus;
  }
}
