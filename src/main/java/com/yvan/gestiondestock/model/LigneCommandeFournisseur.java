package com.yvan.gestiondestock.model;



import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table (name ="LigneCommandeFournisseur")
public class LigneCommandeFournisseur extends AbstractEntity{



  @ManyToOne
  @JoinColumn(name ="idarticle")
  private Article article;

  @ManyToOne
  @JoinColumn(name ="idcommandefournisseur")
  private CommandeFournisseur commandeFournisseur;



  @Column(name = "quantite")
  private BigDecimal quantite;

  @Column(name = "prixunitaire")
  private BigDecimal prixUnitaire;

}
