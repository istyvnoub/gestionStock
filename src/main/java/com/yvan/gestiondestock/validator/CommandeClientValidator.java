package com.yvan.gestiondestock.validator;

import com.yvan.gestiondestock.dto.ClientDto;
import com.yvan.gestiondestock.dto.CommandeClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeClientValidator {
  public static List<String> validate(CommandeClientDto dto) {
  List<String> errors = new ArrayList<>();

    if(dto == null){
    errors.add("Veuillez renseignez le code du CommandeClient");
    errors.add("Veuillez renseigner la date de la CommandeClient ");


  }

    if (!StringUtils.hasLength(dto.getCode())) {
    errors.add("Veuillez renseignez le code de la CommandeClient");
  }

    return errors;
}
}
