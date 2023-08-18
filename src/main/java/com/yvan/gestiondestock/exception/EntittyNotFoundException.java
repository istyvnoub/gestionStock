package com.yvan.gestiondestock.exception;

import lombok.Getter;

public class EntittyNotFoundException extends RuntimeException{
  // Il sagit ici dune Exception generique. Par  exemple au cas on retrouve pas un article il est favorale de renvoyer une ExceptionNotFo

  @Getter
  private ErrorCode errorcode;

  public EntittyNotFoundException (String message){
    super(message);
  }

  public EntittyNotFoundException (String message, Throwable cause){
    super(message,cause);
  }

  public EntittyNotFoundException (String message,Throwable cause, ErrorCode errorCode){
    super(message);

    this.errorcode= errorCode;
  }

}
