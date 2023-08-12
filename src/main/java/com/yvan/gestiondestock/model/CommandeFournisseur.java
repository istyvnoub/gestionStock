package com.yvan.gestiondestock.model;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table (name ="commandeFournisseur")
public class CommandeFournisseur extends AbstractEntity{



  @Column(name="code")
  private String code;

  @Column(name="datecommande")
  private Instant dateCommmande;

  @ManyToOne
  @JoinColumn(name ="idfournisseur")
  private Fournisseur fournisseur;

  @OneToMany(mappedBy = "commandeFournisseur")
  private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;


}
