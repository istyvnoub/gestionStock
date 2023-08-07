package com.yvan.gestiondestock.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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

  @Column(name="numTel")
  private String numTel;

  @Column(name ="photo")
  private String photo;

  @Column(name = "pays")
  private String pays;
}
