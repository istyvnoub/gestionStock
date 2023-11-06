package com.yvan.gestiondestock.services;

import com.yvan.gestiondestock.dto.CommandeClientDto;
import com.yvan.gestiondestock.dto.UtilisateurDto;

import java.util.List;

public interface CommandeClientService {

  CommandeClientDto save (CommandeClientDto dto);

  CommandeClientDto findById (CommandeClientDto id);

  CommandeClientDto findByNom(String nom);


  List<CommandeClientDto> findAll();

  void delete (Integer id);
}
