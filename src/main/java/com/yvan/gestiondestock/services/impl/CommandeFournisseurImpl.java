package com.yvan.gestiondestock.services.impl;

import com.yvan.gestiondestock.dto.CommandeClientDto;
import com.yvan.gestiondestock.dto.CommandeFournisseurDto;
import com.yvan.gestiondestock.dto.LigneCommandeClientDto;
import com.yvan.gestiondestock.dto.LigneCommandeFournisseurDto;
import com.yvan.gestiondestock.exception.EntittyNotFoundException;
import com.yvan.gestiondestock.exception.ErrorCode;
import com.yvan.gestiondestock.exception.InvalidEntittyException;
import com.yvan.gestiondestock.model.*;
import com.yvan.gestiondestock.repository.*;
import com.yvan.gestiondestock.services.CommandeFournisseurService;
import com.yvan.gestiondestock.validator.CommandeClientValidator;
import com.yvan.gestiondestock.validator.CommandeFournisseurValidator;
import com.yvan.gestiondestock.validator.FournisseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommandeFournisseurImpl implements CommandeFournisseurService {
  private CommandeClientRepo commandeClientRepo;
  private ClientRepo clientRepo;

  private ArticleRepository articleRepository;
  private LigneCommandeClientRepo ligneCommandeClientRepo;

  private LigneCommandeFournisseurRepo ligneCommandeFournisseurRepo;

  private CommandeFournisseurRepo commandeFournisseurRepo;

  @Autowired
  public CommandeFournisseurImpl( CommandeClientRepo commandeClientRepo, ClientRepo clientRepo, ArticleRepository articleRepository, LigneCommandeClientRepo ligneCommandeClientRepo , CommandeFournisseurRepo commandeFournisseurRepo,LigneCommandeFournisseurRepo ligneCommandeFournisseurRepo){

    this.commandeClientRepo =commandeClientRepo;
    this.articleRepository = articleRepository;
    this.clientRepo = clientRepo;
    this.ligneCommandeClientRepo = ligneCommandeClientRepo;
    this.commandeFournisseurRepo = commandeFournisseurRepo;
    this.ligneCommandeFournisseurRepo = ligneCommandeFournisseurRepo;
  }
  @Override
  public CommandeFournisseurDto save(CommandeFournisseurDto dto) {

    List<String> errors = CommandeFournisseurValidator.validate(dto);
    if(!errors.isEmpty()){
      log.error("Commande Fournisseur nest pas valide");

      throw new InvalidEntittyException("la commande fournisseur n'est pas valide", ErrorCode.COMMANDE_CLIENT_NOT_VALID,errors);
    }
    Optional<Client> client = clientRepo.findById(dto.getId());

    if(client.isEmpty()){
     log.warn("Client with ID {} was not found in the DB", dto.getFournisseur().getId());
      throw new EntittyNotFoundException("Aucun fournisseur avec l'ID " + dto.getFournisseur().getId() + "n'a ete dans la BD", ErrorCode.COMMANDE_CLIENT_NOT_FOUND);
    }

    List<String> articleErrors  = new ArrayList<>();

    if(dto.getLigneCommandeFournisseurs() != null){
      dto.getLigneCommandeFournisseurs().forEach(lgnCmdclt ->{
        if(lgnCmdclt.getArticle() != null){
          Optional<Article> article = articleRepository.findById(lgnCmdclt.getArticle().getId());
          if (article.isEmpty()) {
            articleErrors.add("L'article avec l'ID " + lgnCmdclt.getArticle().getId() + " n'existe pas");
          }
        } else {
          articleErrors.add("Impossible d'enregister une commande avec un aticle NULL");
        }

      });
    }
    if(!articleErrors.isEmpty()){
      log.warn("");
      throw new InvalidEntittyException("Article n'existe pas dans la BDD", ErrorCode.ARTICLE_NOT_FOUND, articleErrors);
    }
    CommandeFournisseur savedCmdClt = commandeFournisseurRepo.save(CommandeFournisseurDto.toEntity(dto));
    if(dto.getLigneCommandeFournisseurs() != null){
      dto.getLigneCommandeFournisseurs().forEach(lgncmdclt->{
        LigneCommandeFournisseur ligneCommandeFournisseur = LigneCommandeFournisseurDto.toEntity(lgncmdclt);
        ligneCommandeFournisseur.setCommandeFournisseur(savedCmdClt);
        ligneCommandeFournisseurRepo.save(ligneCommandeFournisseur);
      });
    }
    return CommandeFournisseurDto.fromEntity(savedCmdClt);
  }

  @Override
  public CommandeFournisseurDto findById(CommandeFournisseurDto id) {

    if (id == null) {
      log.error("Commande Fournisseur Id is null");

      return null;
    }
    return commandeFournisseurRepo.findById(id.getId()).map(CommandeFournisseurDto::fromEntity)
      .orElseThrow(()-> new EntittyNotFoundException("Aucune Commande fournisseur  n'a ete trouve avec l 'ID" + id , ErrorCode.COMMANDE_FOURNISSEUR_NOT_FOUND));
  }

  @Override
  public CommandeFournisseurDto findByNom(String nom) {
    return null;
  }

  @Override
  public List<CommandeFournisseurDto> findAll() {
    return commandeFournisseurRepo.findAll().stream()
      .map(CommandeFournisseurDto::fromEntity)
      .collect(Collectors.toList());

  }



  @Override
  public CommandeFournisseurDto findByCode (String code){
    if(!StringUtils.hasLength(code)){
      log.error("Commande fournisseur CODE is NULL");
      return null ;
    }

    return commandeFournisseurRepo.findCommandeFournisseurByCode(code)
      .map(CommandeFournisseurDto::fromEntity)
      .orElseThrow(()-> new EntittyNotFoundException(
        "Aucune Commande fournisseur n a ete trouve avec le code" + code, ErrorCode.COMMANDE_FOURNISSEUR_NOT_FOUND
      ));
  }

  @Override
  public void delete(Integer id) {
    if (id == null) {
      log.error("Commande fournisseur ID is NULL");
      return ;
    }
    commandeClientRepo.deleteById(id);
  }
}
