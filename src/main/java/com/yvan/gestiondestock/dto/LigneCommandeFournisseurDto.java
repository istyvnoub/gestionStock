package com.yvan.gestiondestock.dto;

import com.yvan.gestiondestock.model.Article;
import com.yvan.gestiondestock.model.LigneCommandeClient;
import com.yvan.gestiondestock.model.LigneCommandeFournisseur;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder

public class LigneCommandeFournisseurDto {

  private Integer id;

  private ArticleDto article;
  private BigDecimal quantite;

  private BigDecimal prixUnitaire;


  private CommandeFournisseurDto commandeFournisseur;

  public static LigneCommandeFournisseurDto fromEntity(LigneCommandeFournisseur ligneCommandeFournisseur) {
    if (ligneCommandeFournisseur == null) {
      return null;
    }
    return LigneCommandeFournisseurDto.builder()
      .id(ligneCommandeFournisseur.getId())
      .article(ArticleDto.fromEntity(ligneCommandeFournisseur.getArticle()))
      .quantite(ligneCommandeFournisseur.getQuantite())
      .prixUnitaire(ligneCommandeFournisseur.getPrixUnitaire())
      .build();
  }

  public static LigneCommandeFournisseur toEntity(LigneCommandeFournisseurDto dto) {
    if (dto == null) {
      return null;
    }

    LigneCommandeFournisseur ligneCommandeFournisseur = new LigneCommandeFournisseur();
    ligneCommandeFournisseur.setId(dto.getId());
    ligneCommandeFournisseur.setArticle(ArticleDto.toEntity(dto.getArticle()));
    ligneCommandeFournisseur.setPrixUnitaire(dto.getPrixUnitaire());
    ligneCommandeFournisseur.setQuantite(dto.getQuantite());
    return ligneCommandeFournisseur;
  }
}
