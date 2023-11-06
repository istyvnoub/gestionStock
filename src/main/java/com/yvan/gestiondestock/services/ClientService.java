package com.yvan.gestiondestock.services;

import com.yvan.gestiondestock.dto.CategorieDto;
import com.yvan.gestiondestock.dto.ClientDto;

import java.util.List;

public interface ClientService {

  ClientDto save (ClientDto dto);

  ClientDto findById (Integer id);

  ClientDto findByCode(String code);

  List<ClientDto> findAll();

  void delete (Integer id);
}
