package com.yvan.gestiondestock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yvan.gestiondestock.model.Adresse;
import com.yvan.gestiondestock.model.CommandeClient;
import com.yvan.gestiondestock.model.CommandeFournisseur;
import com.yvan.gestiondestock.model.Fournisseur;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder

public class FournisseurDto {

  private Integer id;

  private String nom;


  private String prenom;


  private AdresseDto adresse;


  private String email;


  @JsonIgnore
  private List<CommandeFournisseurDto> commandeFournisseurs;

  public static FournisseurDto fromEntity (Fournisseur fournisseur) {
    if (fournisseur == null){

      return null;
    }

    return FournisseurDto.builder()
      .id(fournisseur.getId())
      .nom(fournisseur.getNom())
      .prenom(fournisseur.getPrenom())
      .email(fournisseur.getEmail())
      .adresse(AdresseDto.fromEntity(fournisseur.getAdresse()))
      .build();



  }

  public static Fournisseur toEntity (FournisseurDto fournisseurDto){
    if(fournisseurDto == null){
      return null;
    }
    Fournisseur fournisseur = new Fournisseur();
    fournisseur.setId(fournisseurDto.getId());
    fournisseur.setNom(fournisseurDto.getNom());
    fournisseur.setPrenom(fournisseurDto.getPrenom());
    fournisseur.setEmail(fournisseurDto.getEmail());
    fournisseur.setAdresse(AdresseDto.toEntity(fournisseurDto.getAdresse()));

    return fournisseur;
  }

}
