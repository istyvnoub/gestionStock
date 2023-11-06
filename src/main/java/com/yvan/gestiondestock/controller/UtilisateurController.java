package com.yvan.gestiondestock.controller;

import com.yvan.gestiondestock.controller.api.UtilisateurApi;
import com.yvan.gestiondestock.dto.ClientDto;
import com.yvan.gestiondestock.dto.UtilisateurDto;
import com.yvan.gestiondestock.services.UtilisateurService;

import java.util.List;

public class UtilisateurController implements UtilisateurApi {


  private UtilisateurService utilisateurService;

  public UtilisateurController(UtilisateurService utilisateurService){

    this.utilisateurService= utilisateurService;

  }

  @Override
  public UtilisateurDto save(UtilisateurDto dto) {
    return utilisateurService.save(dto);
  }

  @Override
  public UtilisateurDto findById(Integer id) {
    return utilisateurService.findById(id);
  }

  @Override
  public UtilisateurDto findByCodeArticle(String nom) {
    return utilisateurService.findByNom(nom);
  }

  @Override
  public List<UtilisateurDto> findAll() {
    return utilisateurService.findAll();
  }

  @Override
  public void delete(Integer id) {

    utilisateurService.delete(id);
  }
}
