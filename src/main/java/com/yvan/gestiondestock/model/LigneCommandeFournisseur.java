package com.yvan.gestiondestock.model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

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

}
