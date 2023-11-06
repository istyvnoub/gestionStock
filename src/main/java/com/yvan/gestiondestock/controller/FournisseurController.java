package com.yvan.gestiondestock.controller;

import com.yvan.gestiondestock.controller.api.FournisseurApi;
import com.yvan.gestiondestock.dto.FournisseurDto;
import com.yvan.gestiondestock.services.FournisseurService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FournisseurController implements FournisseurApi {

  private FournisseurService fournisseurService;

  public FournisseurController(FournisseurService fournisseurService){

    this.fournisseurService= fournisseurService;
  }
  @Override
  public FournisseurDto save(FournisseurDto dto) {
    return fournisseurService.save(dto);
  }

  @Override
  public FournisseurDto findById(Integer id) {
    return fournisseurService.findById(id);
  }

  @Override
  public FournisseurDto findByCodeArticle(String nom) {
    return  fournisseurService.findByNom(nom);
  }

  @Override
  public List<FournisseurDto> findAll() {
    return fournisseurService.findAll();
  }

  @Override
  public void delete(Integer id) {
    fournisseurService.delete(id);

  }
}
