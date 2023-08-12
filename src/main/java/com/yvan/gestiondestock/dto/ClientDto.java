package com.yvan.gestiondestock.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yvan.gestiondestock.model.Adresse;
import com.yvan.gestiondestock.model.Client;
import com.yvan.gestiondestock.model.CommandeClient;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClientDto {

  private Integer id;

  private String nom;


  private String prenom;


  private AdresseDto adresse;


  private String email;



  @JsonIgnore
  private List<CommandeClientDto> commandeClients;


  public static ClientDto fromEntity (Client client) {
    if (client == null){

      return null;
    }

    return ClientDto.builder()
      .id(client.getId())
      .nom(client.getNom())
      .prenom(client.getPrenom())
      .email(client.getEmail())
      .adresse(AdresseDto.fromEntity(client.getAdresse()))
      .build();


  }

  public static Client toEntity  (ClientDto clientDto){
    if(clientDto == null){

      return null;
    }

    Client client = new Client();
    client.setId(clientDto.getId());
    client.setAdresse(AdresseDto.toEntity(clientDto.getAdresse()));
    client.setNom(clientDto.getNom());
    client.setPrenom(clientDto.getPrenom());
    client.setEmail(clientDto.getEmail());

    return client;
  }
}
