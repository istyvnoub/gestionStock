package com.yvan.gestiondestock.services.impl;

import com.yvan.gestiondestock.dto.CategorieDto;
import com.yvan.gestiondestock.dto.ClientDto;
import com.yvan.gestiondestock.exception.EntittyNotFoundException;
import com.yvan.gestiondestock.exception.ErrorCode;
import com.yvan.gestiondestock.exception.InvalidEntittyException;
import com.yvan.gestiondestock.model.Categorie;
import com.yvan.gestiondestock.model.Client;
import com.yvan.gestiondestock.repository.ClientRepo;
import com.yvan.gestiondestock.services.ClientService;
import com.yvan.gestiondestock.validator.CategorieValidator;
import com.yvan.gestiondestock.validator.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

  private ClientRepo clientRepo;

  @Autowired
  public ClientServiceImpl (ClientRepo clientRepo){
    this.clientRepo= clientRepo;


  }
  @Override
  public ClientDto save(ClientDto dto) {
    List<String> errors = ClientValidator.validate(dto);
    if(!errors.isEmpty()){
      log.error("Client is not valid {}",dto);
      throw new InvalidEntittyException("Client nest pas valide", ErrorCode.CLIENT_NOT_VALID,errors);
    }
    ClientDto clientDto = ClientDto.fromEntity(clientRepo.save(ClientDto.toEntity(dto)));
    return clientDto;
  }

  @Override
  public ClientDto findById(Integer id) {
    if (id == null){
      log.error("Client ID is null");

      return null;

    }

    Optional<Client> client = clientRepo.findById(id);



    return Optional.of(ClientDto.fromEntity(client.get())).orElseThrow(()->
      new EntittyNotFoundException(
        "Aucun Client avec l'ID =" + id+ " n'ete trouve dns la BD"));
  }

  @Override
  public ClientDto findByCode(String code) {
    return null;
  }

  @Override
  public List<ClientDto> findAll() {
    return clientRepo.findAll().stream()
      .map(ClientDto::fromEntity)
      .collect(Collectors.toList());
  }

  @Override
  public void delete(Integer id) {
    if (id == null){
      log.error("Client ID is null");

    }
    clientRepo.deleteById(id);
  }
}
