package com.yvan.gestiondestock.model;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table (name ="Entreprise")
public class Entreprise extends AbstractEntity{


  private String nom;
}
