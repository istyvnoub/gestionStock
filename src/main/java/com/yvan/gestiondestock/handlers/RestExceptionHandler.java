package com.yvan.gestiondestock.handlers;

import com.yvan.gestiondestock.exception.EntittyNotFoundException;
import com.yvan.gestiondestock.exception.InvalidEntittyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

  //Gestionnaire Globale d'exception qui permet d'intercepter toutes les Exceptions ayant lieu dans
  // l'application.

  @ExceptionHandler(EntittyNotFoundException.class)
  public ResponseEntity<ErrorDto> handleException(EntittyNotFoundException exception, WebRequest webRequest){

    final HttpStatus notFound = HttpStatus.NOT_FOUND;
    final ErrorDto errorDto = ErrorDto.builder().errorCode(exception.getErrorcode())
      .httpCode(notFound.value())
      .message(exception.getMessage())
      .build();

    return new ResponseEntity<>(errorDto,notFound);
  }

  @ExceptionHandler(InvalidEntittyException.class)
  public ResponseEntity<ErrorDto> handleException(InvalidEntittyException exception, WebRequest webRequest){

    final HttpStatus badRequest = HttpStatus.BAD_REQUEST;
    final ErrorDto errorDto = ErrorDto.builder().errorCode(exception.getErrorCode())
      .httpCode(badRequest.value())
      .message(exception.getMessage())
      .errors(exception.getErrors())
      .build();

    return new ResponseEntity<>(errorDto,badRequest);
  }
}
