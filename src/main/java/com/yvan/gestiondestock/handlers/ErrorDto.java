package com.yvan.gestiondestock.handlers;

import com.yvan.gestiondestock.exception.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ErrorDto {

  private Integer httpCode;

  private ErrorCode errorCode;

  private String message;

  private List<String> errors = new ArrayList<>();
}
