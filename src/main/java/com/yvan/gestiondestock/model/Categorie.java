package com.yvan.gestiondestock.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table (name ="categorie")
public class Categorie extends AbstractEntity{


  private String code;

  private String designation;

  @Column(name = "identreprise")
  private Integer idEntreprise;

  @OneToMany(mappedBy = "categorie")
  private List <Article> articles;

}
