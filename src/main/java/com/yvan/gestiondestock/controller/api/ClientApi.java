package com.yvan.gestiondestock.controller.api;

import com.yvan.gestiondestock.dto.CategorieDto;
import com.yvan.gestiondestock.dto.ClientDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.yvan.gestiondestock.utils.Constants.APP_ROOT;

public interface ClientApi {

  @PostMapping(value = APP_ROOT+ "/client/create", consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
  ClientDto save (@RequestBody ClientDto dto);

  @GetMapping(value = APP_ROOT+"/client/{idClients}",produces = MediaType.APPLICATION_JSON_VALUE)
  ClientDto findById (@PathVariable("idClients") Integer id);

  @GetMapping(value = APP_ROOT+"/client/{clientnom}", produces = MediaType.APPLICATION_JSON_VALUE)
  ClientDto findByCodeArticle(@PathVariable("clientnom") String nom);

  @GetMapping(value = APP_ROOT+"/client/all", produces = MediaType.APPLICATION_JSON_VALUE)
  List<ClientDto> findAll();

  @DeleteMapping(APP_ROOT+"/client/delete/{idClient}")
  void delete (@PathVariable("idClient") Integer id);
}
