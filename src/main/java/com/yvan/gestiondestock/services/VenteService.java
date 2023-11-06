package com.yvan.gestiondestock.services;

import com.yvan.gestiondestock.dto.CommandeClientDto;
import com.yvan.gestiondestock.dto.VentesDto;

import java.util.List;

public interface VenteService {

  VentesDto save (VentesDto dto);

  VentesDto findById (Integer id);

  VentesDto findByNom(String nom);


  List<VentesDto> findAll();

  void delete (Integer id);
}
