package com.yvan.gestiondestock.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table (name ="roles")
public class Roles extends AbstractEntity {


  @Column(name = "rolename")
  private String roleName;

  @Column(name = "identreprise")
  private Integer idEntreprise;

  @ManyToOne
  @JoinColumn(name = "idutilisateur")
  private Utilisateur utilisateur;

}
