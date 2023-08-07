package com.yvan.gestiondestock.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

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

}
