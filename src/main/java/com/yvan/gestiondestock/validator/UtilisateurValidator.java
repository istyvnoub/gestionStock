package com.yvan.gestiondestock.validator;

import com.yvan.gestiondestock.dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {

  public static List <String> validate (UtilisateurDto utilisateurDto){
    List <String> errors = new ArrayList<>();

    if(utilisateurDto == null){

      errors.add("Veuillez le nom de lUtilisateur");
      errors.add("Veuillez entrer le Prenom de lUtilisateur");
    }

    if(!StringUtils.hasLength(utilisateurDto.getNom())){
      errors.add("Veuillez entrer le nom de lUtilisateur");
    }


    if(!StringUtils.hasLength(utilisateurDto.getPrenom())){
      errors.add("Veuillez entrer le prenom de lUtilisateur");
    }

    if(!StringUtils.hasLength(utilisateurDto.getMoteDePasse())){
      errors.add("Veuillez entrer le mot de Passe de lUtilisateur");
    }
    if(!StringUtils.hasLength(utilisateurDto.getEmail())){
      errors.add("Veuillez enter l'email de lUtilisateur");
    }

    if(utilisateurDto.getAdresse()== null){
      errors.add("Veuillez entrez ladresse de l'utilisateur");
    } else {
      if(!StringUtils.hasLength(utilisateurDto.getAdresse().getAdresse1())){
        errors.add("Le champs 'Adresse 1' est obligatoire ");
      }
      if(!StringUtils.hasLength(utilisateurDto.getAdresse().getAdresse2())){
        errors.add("Le champs 'Adresse 2' est obligatoire ");
      }

      if(!StringUtils.hasLength(utilisateurDto.getAdresse().getPays())){
        errors.add("Le champs 'Pays' est obligatoire ");
      }
      if(!StringUtils.hasLength(utilisateurDto.getAdresse().getVille())){
        errors.add("Le champs 'Ville' est obligatoire ");
      }
    }

    return errors ;

  }
}
