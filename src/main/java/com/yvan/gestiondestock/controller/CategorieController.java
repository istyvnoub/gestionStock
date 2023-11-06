package com.yvan.gestiondestock.controller;

import com.yvan.gestiondestock.controller.api.CategorieApi;
import com.yvan.gestiondestock.dto.ArticleDto;
import com.yvan.gestiondestock.dto.CategorieDto;
import com.yvan.gestiondestock.services.CategorieService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategorieController implements CategorieApi {

  private CategorieService categorieService;

  public CategorieController(CategorieService categorieService){

    this.categorieService= categorieService;
  }
  @Override
  public CategorieDto save(CategorieDto dto) {
    return  categorieService.save(dto);
  }

  @Override
  public CategorieDto findById(Integer id) {
    return categorieService.findById(id);
  }

  @Override
  public CategorieDto findByCodeArticle(String code) {
    return categorieService.findByCode(code);
  }

  @Override
  public List<CategorieDto> findAll() {
    return categorieService.findAll();
  }

  @Override
  public void delete(Integer id) {
    categorieService.delete(id);

  }
}
