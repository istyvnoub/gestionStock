package com.yvan.gestiondestock.controller.api;

import com.yvan.gestiondestock.dto.FournisseurDto;
import com.yvan.gestiondestock.dto.UtilisateurDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.yvan.gestiondestock.utils.Constants.APP_ROOT;

public interface FournisseurApi {

  @PostMapping(value = APP_ROOT+ "/fournisseur/create", consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
  FournisseurDto save (@RequestBody FournisseurDto dto);

  @GetMapping(value = APP_ROOT+"/fournisseur/{idFournisseur}",produces = MediaType.APPLICATION_JSON_VALUE)
  FournisseurDto findById (@PathVariable("idFournisseur") Integer id);

  @GetMapping(value = APP_ROOT+"/fournisseur/{fournisseurnom}", produces = MediaType.APPLICATION_JSON_VALUE)
  FournisseurDto findByCodeArticle(@PathVariable("fournisseurnom") String nom);

  @GetMapping(value = APP_ROOT+"/fournisseur/all", produces = MediaType.APPLICATION_JSON_VALUE)
  List<FournisseurDto> findAll();

  @DeleteMapping(APP_ROOT+"/fournisseur/delete/{idFournisseur}")
  void delete (@PathVariable("idFournisseur") Integer id);
}
