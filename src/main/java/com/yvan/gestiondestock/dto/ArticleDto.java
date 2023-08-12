package com.yvan.gestiondestock.dto;

import com.yvan.gestiondestock.model.Article;
import com.yvan.gestiondestock.model.Categorie;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ArticleDto {

  private Integer id;

  private String codeArticle;


  private String designation;


  private String prixUnitaire;


  private BigDecimal tauxTva;


  private BigDecimal prixUnitaireTtc;


  private String photo;


  private CategorieDto categorie;

  public static ArticleDto fromEntity(Article article){

    if (article == null){
       return null;
    }
     return ArticleDto.builder()
       .id(article.getId())
       .codeArticle(article.getCodeArticle())
       .designation(article.getDesignation())
       .prixUnitaire(article.getPrixUnitaire())
       .tauxTva(article.getTauxTva())
       .prixUnitaireTtc(article.getPrixUnitaireTtc())
       .categorie(CategorieDto.fromEntity(article.getCategorie()))
       .photo(article.getPhoto())
       .build();
  }

  public static Article toEntity(ArticleDto articleDto){
    if (articleDto == null){
       return null ;

    }
     Article article = new Article();
     article.setId(articleDto.getId());
     article.setCodeArticle(articleDto.getCodeArticle());
     article.setPhoto(articleDto.getPhoto());
     article.setDesignation(articleDto.getDesignation());
     article.setPrixUnitaire(articleDto.getPrixUnitaire());
     article.setTauxTva(articleDto.getTauxTva());
     article.setPrixUnitaireTtc(articleDto.getPrixUnitaireTtc());
    article.setCategorie(CategorieDto.toEntity(articleDto.getCategorie()));

    return article;
  }

}
