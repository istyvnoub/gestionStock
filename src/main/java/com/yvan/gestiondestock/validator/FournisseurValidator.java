package com.yvan.gestiondestock.validator;

import com.yvan.gestiondestock.dto.ClientDto;
import com.yvan.gestiondestock.dto.FournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FournisseurValidator {
  public static List<String> validate(FournisseurDto dto) {
    List<String> errors = new ArrayList<>();

    if(dto == null){
      errors.add("Veuillez renseignez le Nom du Fournisseur");
      errors.add("Veuillez renseigner le prenom du Fournisseur ");
      errors.add("Veuillez renseigner l'Email du Fournisseur");

    }

    if (!StringUtils.hasLength(dto.getNom())) {
      errors.add("Veuillez renseignez le Nom du Fournisseur");
    }

    if (!StringUtils.hasLength(dto.getPrenom())) {
      errors.add("Veuillez renseigner le prenom du Fournisseur");
    }

    if (!StringUtils.hasLength(dto.getEmail())) {
      errors.add("Veuillez renseigner l'Email du Fournisseur");

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
