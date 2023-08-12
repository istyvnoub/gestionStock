package com.yvan.gestiondestock.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name ="adresse")
public class Adresse  {

  @Column(name ="adresse1")
  private String adresse1;

  @Column(name ="adresse2")
  private String adresse2;

  @Column(name="ville")
  private String ville;

  @Column(name = "pays")
  private String pays;
}
