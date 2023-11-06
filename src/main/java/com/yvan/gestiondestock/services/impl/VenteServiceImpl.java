package com.yvan.gestiondestock.services.impl;

import com.yvan.gestiondestock.dto.CommandeClientDto;
import com.yvan.gestiondestock.dto.VentesDto;
import com.yvan.gestiondestock.exception.EntittyNotFoundException;
import com.yvan.gestiondestock.exception.ErrorCode;
import com.yvan.gestiondestock.exception.InvalidEntittyException;
import com.yvan.gestiondestock.model.Article;
import com.yvan.gestiondestock.model.LigneVente;
import com.yvan.gestiondestock.model.Ventes;
import com.yvan.gestiondestock.repository.ArticleRepository;
import com.yvan.gestiondestock.repository.LigneVenteRepo;
import com.yvan.gestiondestock.repository.VentesRepo;
import com.yvan.gestiondestock.services.VenteService;
import com.yvan.gestiondestock.validator.VenteValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VenteServiceImpl implements VenteService {

  private ArticleRepository articleRepository;
  private VentesRepo ventesRepo;
  private LigneVenteRepo ligneVenteRepo;

  public VenteServiceImpl (ArticleRepository articleRepository, VentesRepo ventesRepo, LigneVenteRepo ligneVenteRepo)
  {
    this.articleRepository= articleRepository;
    this.ligneVenteRepo= ligneVenteRepo;
    this.ventesRepo= ventesRepo;
  }
  @Override
  public VentesDto save(VentesDto dto) {
    List<String> errors = VenteValidator.validate(dto);
      if(!errors.isEmpty()){
        log.error("Vente n'est pas valide");
        throw new InvalidEntittyException("Lobjet nest pas valide", ErrorCode.VENTE_NOT_VALID, errors);
      }

      List<String> articleErrors = new ArrayList<>();

      dto.getLigneVentes().forEach(ligneVenteDto -> {
        Optional< Article> article = articleRepository.findById(ligneVenteDto.getArticle().getId());
        if (article.isEmpty()){
          articleErrors.add("Aucun article avec L'Id"+ ligneVenteDto.getArticle().getId()+ " n'a ete trouve dans la DB");
        }

      });

      if(!articleErrors.isEmpty()){
        log.error("One or more Article was not found in the DB, {}", errors);
        throw new InvalidEntittyException("un ou plusieur articles n'ont pas ete trouve dans la base de donnee", ErrorCode.ARTICLE_NOT_FOUND,errors);
      }

    Ventes savedVentes = ventesRepo.save(VentesDto.toEntity(dto));

      dto.getLigneVentes().forEach(ligneVenteDto -> {
        LigneVente ligneVente = ligneVenteDto.toEntity(ligneVenteDto);
        ligneVente.setVente(savedVentes);
        ligneVenteRepo.save(ligneVente);
      });
    return VentesDto.fromEntity(savedVentes);
  }

  @Override
  public VentesDto findById(Integer id) {
    if(id == null){
      log.error("vente ID is NULL");

      return null ;
    }
    return ventesRepo.findById(id)
      .map(VentesDto::fromEntity)
      .orElseThrow(()-> new EntittyNotFoundException("Aucune Vente na ete trouve dans la BDD", ErrorCode.VENTE_NOT_FOUND));
  }

  @Override
  public VentesDto findByNom(String nom) {
    return null;
  }

  @Override
  public List<VentesDto> findAll() {
    return ventesRepo.findAll().stream()
      .map(VentesDto::fromEntity)
      .collect(Collectors.toList());
  }

  @Override
  public void delete(Integer id) {
    if(id== null){
      log.error("vente ID is null");
      return;
    }

    ventesRepo.deleteById(id);

  }
}
