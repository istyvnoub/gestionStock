package com.yvan.gestiondestock.services.impl;

import com.yvan.gestiondestock.dto.ArticleDto;
import com.yvan.gestiondestock.dto.CategorieDto;
import com.yvan.gestiondestock.exception.EntittyNotFoundException;
import com.yvan.gestiondestock.exception.ErrorCode;
import com.yvan.gestiondestock.exception.InvalidEntittyException;
import com.yvan.gestiondestock.model.Article;
import com.yvan.gestiondestock.model.Categorie;
import com.yvan.gestiondestock.repository.CategorieRepo;
import com.yvan.gestiondestock.services.CategorieService;
import com.yvan.gestiondestock.validator.ArticleValidator;
import com.yvan.gestiondestock.validator.CategorieValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CategorieImpl implements CategorieService {

  private CategorieRepo categorieRepo;

  @Autowired
  public CategorieImpl (CategorieRepo categorieRepo){

    this.categorieRepo = categorieRepo;
  }
  @Override
  public CategorieDto save(CategorieDto dto) {
    List<String> errors = CategorieValidator.validate(dto);
    if(!errors.isEmpty()){
      log.error("Category is not valid {}",dto);
      throw new InvalidEntittyException("Categorie nest pas valide", ErrorCode.CATEGORY_NOT_VALID,errors);
    }
    CategorieDto categorieDto = CategorieDto.fromEntity(categorieRepo.save(CategorieDto.toEntity(dto)));
    return categorieDto;
  }

  @Override
  public CategorieDto findById(Integer id) {
    if (id == null){
      log.error("Category ID is null");

      return null;

    }

    Optional<Categorie> categorie = categorieRepo.findById(id);



    return Optional.of(CategorieDto.fromEntity(categorie.get())).orElseThrow(()->
      new EntittyNotFoundException(
        "Aucun categorie avec l'ID =" + id+ " n'ete trouve dns la BD"));

  }

  @Override
  public CategorieDto findByCode(String code) {
  return null;
  }

  @Override
  public List<CategorieDto> findAll() {
    return categorieRepo.findAll().stream()
      .map(CategorieDto::fromEntity)
      .collect(Collectors.toList());
  }

  @Override
  public void delete(Integer id) {
    if (id == null){
      log.error("Categorie ID is null");

    }
    categorieRepo.deleteById(id);

  }
}
