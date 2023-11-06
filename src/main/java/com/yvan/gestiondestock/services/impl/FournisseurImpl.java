package com.yvan.gestiondestock.services.impl;

import com.yvan.gestiondestock.dto.FournisseurDto;
import com.yvan.gestiondestock.dto.UtilisateurDto;
import com.yvan.gestiondestock.exception.EntittyNotFoundException;
import com.yvan.gestiondestock.exception.ErrorCode;
import com.yvan.gestiondestock.exception.InvalidEntittyException;
import com.yvan.gestiondestock.model.Fournisseur;
import com.yvan.gestiondestock.model.Utilisateur;
import com.yvan.gestiondestock.repository.FournisseurRepo;
import com.yvan.gestiondestock.repository.UtilisateurRepo;
import com.yvan.gestiondestock.services.FournisseurService;
import com.yvan.gestiondestock.validator.FournisseurValidator;
import com.yvan.gestiondestock.validator.UtilisateurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FournisseurImpl implements FournisseurService {

  private FournisseurRepo fournisseurRepo;

  @Autowired
  public FournisseurImpl(FournisseurRepo fournisseurRepo){
    this.fournisseurRepo= fournisseurRepo;
  }

  @Override
  public FournisseurDto save(FournisseurDto dto) {
    List<String> errors = FournisseurValidator.validate(dto);
    if(!errors.isEmpty()){
      log.error("Utilisateur is not valid {}",dto);
      throw new InvalidEntittyException("Utilisateur nest pas valide", ErrorCode.UTILISATEUR_NOT_FOUND,errors);
    }
    FournisseurDto fournisseurDto = FournisseurDto.fromEntity(fournisseurRepo.save(FournisseurDto.toEntity(dto)));
    return fournisseurDto;
  }

  @Override
  public FournisseurDto findById(Integer id) {

    if(id== null){
      log.error("Utilisateur ID is null");

      return null;
    }
    Optional<Fournisseur> fournisseur = fournisseurRepo.findById(id);



    return Optional.of(FournisseurDto.fromEntity(fournisseur.get())).orElseThrow(()->
      new EntittyNotFoundException(
        "Aucun Fournisseur avec l'ID =" + id+ " n'ete trouve dns la BD"));
  }

  @Override
  public FournisseurDto findByNom(String nom) {
    return null;
  }

  @Override
  public List<FournisseurDto> findAll() {
    return fournisseurRepo.findAll().stream()
      .map(FournisseurDto::fromEntity)
      .collect(Collectors.toList());
  }

  @Override
  public void delete(Integer id) {
    fournisseurRepo.deleteById(id);
  }
}
