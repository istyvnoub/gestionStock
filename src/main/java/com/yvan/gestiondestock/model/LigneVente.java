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
@Table (name ="LigneVente")
public class LigneVente extends AbstractEntity {



  @ManyToOne
  @JoinColumn(name = "idvente")
  private Ventes vente;

  @ManyToOne
  @JoinColumn(name = "idarticle")
  private Article article;

  @Column(name = "quantite")
  private BigDecimal quantite;

  @Column(name = "prixunitaire")
  private BigDecimal prixUnitaire;


  @Column(name = "identreprise")
  private Integer idEntreprise;
}
