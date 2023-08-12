package com.yvan.gestiondestock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yvan.gestiondestock.model.CommandeClient;
import com.yvan.gestiondestock.model.CommandeFournisseur;
import com.yvan.gestiondestock.model.Fournisseur;
import com.yvan.gestiondestock.model.LigneCommandeFournisseur;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class CommandeFournisseurDto {

  private Integer id;


  private String code;


  private Instant dateCommmande;


  private FournisseurDto fournisseur;


  @JsonIgnore
  private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs;


  public static CommandeFournisseurDto fromEntity (CommandeFournisseur commandeFournisseur) {
    if (commandeFournisseur == null){

      return null;
    }

    return CommandeFournisseurDto.builder()
      .id(commandeFournisseur.getId())
      .code(commandeFournisseur.getCode())
      .dateCommmande(commandeFournisseur.getDateCommmande())
      .fournisseur(FournisseurDto.fromEntity(commandeFournisseur.getFournisseur()))
      .build();



  }

  public static CommandeFournisseur toEntity (CommandeFournisseurDto commandeFournisseurDto){
    if(commandeFournisseurDto == null){
      return null;
    }
    CommandeFournisseur commandeFournisseur = new CommandeFournisseur();
    commandeFournisseur.setId(commandeFournisseurDto.getId());
    commandeFournisseur.setCode(commandeFournisseurDto.getCode());
    commandeFournisseur.setFournisseur(FournisseurDto.toEntity(commandeFournisseurDto.getFournisseur()));
    commandeFournisseur.setDateCommmande(commandeFournisseurDto.getDateCommmande());

    return commandeFournisseur;
  }
}
