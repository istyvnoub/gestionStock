package com.yvan.gestiondestock.services;

import com.yvan.gestiondestock.dto.ClientDto;
import com.yvan.gestiondestock.dto.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {

  UtilisateurDto save (UtilisateurDto dto);

  UtilisateurDto findById (Integer id);

  UtilisateurDto findByNom(String nom);

  List<UtilisateurDto> findAll();

  void delete (Integer id);
}
