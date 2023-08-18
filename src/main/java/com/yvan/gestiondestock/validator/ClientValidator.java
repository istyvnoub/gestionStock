package com.yvan.gestiondestock.validator;

import com.yvan.gestiondestock.dto.ArticleDto;
import com.yvan.gestiondestock.dto.ClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {

  public static List<String> validate(ClientDto dto) {
    List<String> errors = new ArrayList<>();

    if(dto == null){
      errors.add("Veuillez renseignez le Nom du Client");
      errors.add("Veuillez renseigner le prenom du client ");
      errors.add("Veuillez renseigner l'Email du Client");

    }

    if (!StringUtils.hasLength(dto.getNom())) {
      errors.add("Veuillez renseignez le Nom du Client");
    }

    if (!StringUtils.hasLength(dto.getPrenom())) {
      errors.add("Veuillez renseigner le prenom du client ");
    }

    if (!StringUtils.hasLength(dto.getEmail())) {
      errors.add("Veuillez renseigner l'Email du Client");

    }
    if (dto.getAdresse()== null) {
      errors.add("veuillez renseigner lAdresse du Fourniseur ");
    }else {
      if(!StringUtils.hasLength(dto.getAdresse().getAdresse1())){
        errors.add("Le champs 'Adresse 1' est obligatoire ");
      }
      if(!StringUtils.hasLength(dto.getAdresse().getAdresse2())){
        errors.add("Le champs 'Adresse 2' est obligatoire ");
      }

      if(!StringUtils.hasLength(dto.getAdresse().getPays())){
        errors.add("Le champs 'Pays' est obligatoire ");
      }
      if(!StringUtils.hasLength(dto.getAdresse().getVille())){
        errors.add("Le champs 'Ville' est obligatoire ");
      }
    }
    return errors;
  }
}
