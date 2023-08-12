package com.yvan.gestiondestock.model;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table (name ="MvStck")
public class MvStck extends AbstractEntity{



  @Column(name = "datemvt")
  private Instant dateMvt;

  @Column(name = "quantite")
  private BigDecimal quantite;

  @ManyToOne
  @JoinColumn(name = "idarticle")
  private Article article;

  @Column(name = "identreprise")
  private Integer idEntreprise;
}
