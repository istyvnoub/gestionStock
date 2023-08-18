package com.yvan.gestiondestock.exception;

import lombok.Getter;

import java.util.List;

public class InvalidEntittyException extends RuntimeException{
  @Getter
  private ErrorCode errorCode;
  @Getter
  private List<String> errors;

  public InvalidEntittyException (String message){
    super(message);
  }

  public InvalidEntittyException (String message, Throwable cause){
    super(message,cause);
  }

  public InvalidEntittyException (String message,Throwable cause, ErrorCode errorCode){
    super(message);

    this.errorCode= errorCode;
  }

  public InvalidEntittyException (String message,ErrorCode errorCode,List<String> errors){

    super(message);
this.errorCode= errorCode;
    this.errors= errors;
  }
}
