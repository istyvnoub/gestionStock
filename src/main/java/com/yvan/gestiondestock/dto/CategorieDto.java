package com.yvan.gestiondestock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yvan.gestiondestock.model.Categorie;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategorieDto {

  private Integer id;

  private String code;

  private String designation;

  @JsonIgnore
  private List<ArticleDto> articles;

  public static CategorieDto fromEntity(Categorie categorie){
    if (categorie == null){
       return null;
       //TODO throw Exception
    }


    // Mapping de Category -> categoryDto
    return CategorieDto.builder()
      .id(categorie.getId())
      .code(categorie.getCode())
      .designation(categorie.getDesignation())
      .build() ;
  }

  public static Categorie toEntity(CategorieDto categorieDto) {
    if (categorieDto == null){
      return null ;
    }

    Categorie categorie = new Categorie();
    categorie.setId(categorieDto.getId());
    categorie.setCode(categorieDto.getCode());
    categorie.setDesignation(categorieDto.getDesignation());

    return categorie;
  }

}
