package com.yvan.gestiondestock.services.impl;

import com.yvan.gestiondestock.dto.ClientDto;
import com.yvan.gestiondestock.dto.UtilisateurDto;
import com.yvan.gestiondestock.exception.EntittyNotFoundException;
import com.yvan.gestiondestock.exception.ErrorCode;
import com.yvan.gestiondestock.exception.InvalidEntittyException;
import com.yvan.gestiondestock.model.Client;
import com.yvan.gestiondestock.model.Utilisateur;
import com.yvan.gestiondestock.repository.UtilisateurRepo;
import com.yvan.gestiondestock.services.UtilisateurService;
import com.yvan.gestiondestock.validator.ClientValidator;
import com.yvan.gestiondestock.validator.UtilisateurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UtilisateurImpl implements UtilisateurService {

  private UtilisateurRepo utilisateurRepo;

  @Autowired
  public UtilisateurImpl(UtilisateurRepo utilisateurRepo){
    this.utilisateurRepo= utilisateurRepo;
  }
  @Override
  public UtilisateurDto save(UtilisateurDto dto) {
    List<String> errors = UtilisateurValidator.validate(dto);
    if(!errors.isEmpty()){
      log.error("Utilisateur is not valid {}",dto);
      throw new InvalidEntittyException("Utilisateur nest pas valide", ErrorCode.UTILISATEUR_NOT_FOUND,errors);
    }
    UtilisateurDto utilisateurDto = UtilisateurDto.fromEntity(utilisateurRepo.save(UtilisateurDto.toEntity(dto)));
    return utilisateurDto;
  }

  @Override
  public UtilisateurDto findById(Integer id) {

    if(id== null){
      log.error("Utilisateur ID is null");

      return null;
    }
    Optional <Utilisateur> utilisateur = utilisateurRepo.findById(id);
    if (id == null){
      log.error("Utilisateur ID is null");

      return null;

    }

    Optional<Utilisateur> utilisateur1 = utilisateurRepo.findById(id);



    return Optional.of(UtilisateurDto.fromEntity(utilisateur1.get())).orElseThrow(()->
      new EntittyNotFoundException(
        "Aucun Utilisateur avec l'ID =" + id+ " n'ete trouve dns la BD"));
  }

  @Override
  public UtilisateurDto findByNom(String nom) {
    return null;
  }

  @Override
  public List<UtilisateurDto> findAll() {
    return utilisateurRepo.findAll().stream()
      .map(UtilisateurDto::fromEntity)
      .collect(Collectors.toList());
  }

  @Override
  public void delete(Integer id) {
    utilisateurRepo.deleteById(id);
  }
}
