package com.yvan.gestiondestock.dto;

import com.yvan.gestiondestock.model.Client;
import com.yvan.gestiondestock.model.Entreprise;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EntrepriseDto {

  private Integer id;

  private String nom;

  public static EntrepriseDto fromEntity (Entreprise entreprise) {
    if (entreprise== null){

      return null;
    }

    return EntrepriseDto.builder()
      .id(entreprise.getId())
      .nom(entreprise.getNom())
      .build();


  }

  public static Entreprise toEntity  (EntrepriseDto entrepriseDto){
    if(entrepriseDto == null){

      return null;
    }

    Entreprise entreprise = new Entreprise();
    entreprise.setId(entrepriseDto.getId());
    entreprise.setNom(entrepriseDto.getNom());


    return entreprise;
  }
}
