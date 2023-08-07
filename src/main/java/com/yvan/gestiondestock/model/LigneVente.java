package com.yvan.gestiondestock.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
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
  @JoinColumn(name ="idvente")
  private Ventes vente;

  private BigDecimal quantities ;
}
