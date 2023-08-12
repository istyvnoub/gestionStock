package com.yvan.gestiondestock.model;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table (name ="article")
public class Article extends AbstractEntity {

  @Column(name="codearticle")
  private String codeArticle;

  @Column(name="designation")
  private String designation;

  @Column(name= "prixUnitaire")
  private String prixUnitaire;

  @Column(name="tauxtva")
  private BigDecimal tauxTva;

  @Column(name="prixunitairettc")
  private BigDecimal prixUnitaireTtc;

  @Column(name="photo") //  renvoie la chaine de charatere de la photo stocke dans le cloud.
  private String photo;

  @ManyToOne
  @JoinColumn(name ="idcategorie")
  private Categorie categorie;
}
