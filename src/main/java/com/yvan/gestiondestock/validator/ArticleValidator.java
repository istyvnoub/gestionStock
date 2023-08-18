package com.yvan.gestiondestock.validator;

import com.yvan.gestiondestock.dto.ArticleDto;
import com.yvan.gestiondestock.dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {

  public static List<String> validate(ArticleDto dto) {
    List<String> errors = new ArrayList<>();

    if(dto == null){
      errors.add("Veuillez renseignez le code de larticle");
      errors.add("Veuillez renseigner la designation de larticle ");
      errors.add("Veuillez renseigner le prix Unitaire de larticle ");
      errors.add("veuillez renseigner le taux TVA de l'article");
      errors.add("veuillez renseigner la categorie de larticle ");

    }

    if (!StringUtils.hasLength(dto.getCodeArticle())) {
      errors.add("Veuillez renseignez le code de larticle");
    }

    if (!StringUtils.hasLength(dto.getDesignation())) {
      errors.add("Veuillez renseigner la designation de larticle ");
    }

    if (dto.getPrixUnitaire() == null) {
      errors.add("Veuillez renseigner le prix Unitaire de larticle ");

    }
    if (dto.getTauxTva() == null) {
      errors.add("veuillez renseigner le taux TVA de l'article");
    }
    if(dto.getCategorie()== null){

      errors.add("veuillez renseigner la categorie de larticle ");
    }
    return errors;
  }

}
