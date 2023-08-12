package com.yvan.gestiondestock.dto;

import com.yvan.gestiondestock.model.MvStck;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class MvStckDto {

  private Integer id;

  private Instant dateMvt;

  private BigDecimal quantite;

  private ArticleDto article;

  private Integer idEntreprise;

  public static MvStckDto fromEntity(MvStck mvtStk) {
    if (mvtStk == null) {
      return null;
    }

    return MvStckDto.builder()
      .id(mvtStk.getId())
      .dateMvt(mvtStk.getDateMvt())
      .quantite(mvtStk.getQuantite())
      .article(ArticleDto.fromEntity(mvtStk.getArticle()))
      .idEntreprise(mvtStk.getIdEntreprise())
      .build();
  }

  public static MvStck toEntity(MvStckDto dto) {
    if (dto == null) {
      return null;
    }

    MvStck mvtStk = new MvStck();
    mvtStk.setId(dto.getId());
    mvtStk.setDateMvt(dto.getDateMvt());
    mvtStk.setQuantite(dto.getQuantite());
    mvtStk.setArticle(ArticleDto.toEntity(dto.getArticle()));
    mvtStk.setIdEntreprise(dto.getIdEntreprise());
    return mvtStk;
  }
}
