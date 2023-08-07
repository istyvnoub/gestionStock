package com.yvan.gestiondestock.model;

import java.util.List;

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
@Table (name ="categorie")
public class Categorie extends AbstractEntity{


  private String code;

  private String designation;

  @OneToMany(mappedBy = "categorie")
  private List <Article> articles;

}
