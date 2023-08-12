package com.yvan.gestiondestock.model;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table (name ="Client")
public class Client extends AbstractEntity{



  @Column(name = "nom")
  private String nom;

  @Column(name = "prenom")
  private String prenom;

  @Embedded
  private Adresse adresse;

  @Column(name = "email")
  private String email;


  @OneToMany(mappedBy = "client")
  private List <CommandeClient> commandeClients;
}
