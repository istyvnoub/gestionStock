package com.yvan.gestiondestock.services;

import com.yvan.gestiondestock.dto.CommandeClientDto;
import com.yvan.gestiondestock.dto.CommandeFournisseurDto;

import java.util.List;

public interface CommandeFournisseurService {
  CommandeFournisseurDto save (CommandeFournisseurDto dto);

  CommandeFournisseurDto findById (CommandeFournisseurDto id);

  CommandeFournisseurDto findByNom(String nom);
  CommandeFournisseurDto findByCode(String code);
  List<CommandeFournisseurDto> findAll();

  void delete (Integer id);
}
