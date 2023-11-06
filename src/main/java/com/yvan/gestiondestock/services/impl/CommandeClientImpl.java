package com.yvan.gestiondestock.services.impl;

import ch.qos.logback.core.spi.ErrorCodes;
import com.yvan.gestiondestock.dto.CommandeClientDto;
import com.yvan.gestiondestock.dto.LigneCommandeClientDto;
import com.yvan.gestiondestock.exception.EntittyNotFoundException;
import com.yvan.gestiondestock.exception.ErrorCode;
import com.yvan.gestiondestock.exception.InvalidEntittyException;
import com.yvan.gestiondestock.model.Article;
import com.yvan.gestiondestock.model.Client;
import com.yvan.gestiondestock.model.CommandeClient;
import com.yvan.gestiondestock.model.LigneCommandeClient;
import com.yvan.gestiondestock.repository.ArticleRepository;
import com.yvan.gestiondestock.repository.ClientRepo;
import com.yvan.gestiondestock.repository.CommandeClientRepo;
import com.yvan.gestiondestock.repository.LigneCommandeClientRepo;
import com.yvan.gestiondestock.services.CommandeClientService;
import com.yvan.gestiondestock.validator.CommandeClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommandeClientImpl implements CommandeClientService {

  private CommandeClientRepo commandeClientRepo;
  private ClientRepo clientRepo;

  private ArticleRepository articleRepository;
  private LigneCommandeClientRepo ligneCommandeClientRepo;

  @Autowired
  public CommandeClientImpl( CommandeClientRepo commandeClientRepo, ClientRepo clientRepo, ArticleRepository articleRepository, LigneCommandeClientRepo ligneCommandeClientRepo ){

    this.commandeClientRepo =commandeClientRepo;
    this.articleRepository = articleRepository;
    this.clientRepo = clientRepo;
    this.ligneCommandeClientRepo = ligneCommandeClientRepo;
  }
  @Override
  public CommandeClientDto save(CommandeClientDto dto) {

    List <String>  errors = CommandeClientValidator.validate(dto);
    if(!errors.isEmpty()){
      log.error("Commande Client nest pas valide");

      throw new InvalidEntittyException("la commande client n'est pas valide", ErrorCode.COMMANDE_CLIENT_NOT_VALID,errors);
    }
    Optional<Client> client = clientRepo.findById(dto.getClient().getId());

    if(client.isEmpty()){
      log.warn("Client with ID {} was not found in the DB", dto.getClient().getId());
      throw new EntittyNotFoundException("Aucun client avec l'ID " + dto.getClient().getId() + "n'a ete dans la BD", ErrorCode.COMMANDE_CLIENT_NOT_FOUND);
    }

    List<String> articleErrors  = new ArrayList<>();

    if(dto.getLigneCommandeClients() != null){
      dto.getLigneCommandeClients().forEach(lgnCmdclt ->{
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
    CommandeClient savedCmdClt = commandeClientRepo.save(CommandeClientDto.toEntity(dto));
    if(dto.getLigneCommandeClients() != null){
      dto.getLigneCommandeClients().forEach(lgncmdclt->{
        LigneCommandeClient ligneCommandeClient = LigneCommandeClientDto.toEntity(lgncmdclt);
        ligneCommandeClient.setCommandeClient(savedCmdClt);
        ligneCommandeClientRepo.save(ligneCommandeClient);
      });
    }
    return CommandeClientDto.fromEntity(savedCmdClt);
  }

  @Override
  public CommandeClientDto findById(CommandeClientDto id) {

    if (id == null) {
      log.error("Commande client Id is null");

      return null;
    }
    return commandeClientRepo.findById(id.getId()).map(CommandeClientDto::fromEntity)
      .orElseThrow(()-> new EntittyNotFoundException("Aucune Commande n'a ete trouve avec l 'ID" + id , ErrorCode.COMMANDE_CLIENT_NOT_FOUND));
  }

  @Override
  public CommandeClientDto findByNom(String nom) {
    return null;
  }

  @Override
  public List<CommandeClientDto> findAll() {
    return commandeClientRepo.findAll().stream()
      .map(CommandeClientDto::fromEntity)
      .collect(Collectors.toList());

  }

  @Override
  public void delete(Integer id) {
    if (id == null) {
      log.error("Commande client ID is NULL");
      return ;
    }
    commandeClientRepo.deleteById(id);
}
}
