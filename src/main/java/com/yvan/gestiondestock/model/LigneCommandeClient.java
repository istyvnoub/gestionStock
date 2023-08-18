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
@Table (name ="LigneCommandeClient")
public class LigneCommandeClient extends AbstractEntity {




  @ManyToOne
  @JoinColumn(name ="idarticle")
  private Article article;

  @ManyToOne
  @JoinColumn(name="idcommandeclient")
  private CommandeClient commandeClient;

  @Column(name = "quantite")
  private BigDecimal quantite;

  @Column(name = "identreprise")
  private Integer idEntreprise;

  @Column(name = "prixunitaire")
  private BigDecimal prixUnitaire;

}
