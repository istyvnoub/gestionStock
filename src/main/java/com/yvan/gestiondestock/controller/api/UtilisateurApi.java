package com.yvan.gestiondestock.controller.api;

import com.yvan.gestiondestock.dto.ClientDto;
import com.yvan.gestiondestock.dto.UtilisateurDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.yvan.gestiondestock.utils.Constants.APP_ROOT;

public interface UtilisateurApi {
  @PostMapping(value = APP_ROOT+ "/utilisateur/create", consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
  UtilisateurDto save (@RequestBody UtilisateurDto dto);

  @GetMapping(value = APP_ROOT+"/utilisateur/{idUtilisateurs}",produces = MediaType.APPLICATION_JSON_VALUE)
  UtilisateurDto findById (@PathVariable("idUtilisateurs") Integer id);

  @GetMapping(value = APP_ROOT+"/utilisateur/{utilisateurnom}", produces = MediaType.APPLICATION_JSON_VALUE)
  UtilisateurDto findByCodeArticle(@PathVariable("utilisateurnom") String nom);

  @GetMapping(value = APP_ROOT+"/utilisateur/all", produces = MediaType.APPLICATION_JSON_VALUE)
  List<UtilisateurDto> findAll();

  @DeleteMapping(APP_ROOT+"/utilisateur/delete/{idUtilisateur}")
  void delete (@PathVariable("idUtilisateur") Integer id);
}
