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
@Table (name ="commandeClient")
public class CommandeClient extends AbstractEntity{


  @Column(name = "code")
  private String code ;

  @Column(name = "datecommande")
  private Instant dateCommande;

  @ManyToOne
  @JoinColumn(name = "idclient")
  private Client client;

  @Column(name = "identreprise")
  private Integer idEntreprise;

  @OneToMany(mappedBy = "commandeClient")
  private List<LigneCommandeClient> ligneCommandeClients;
}
