package com.yvan.gestiondestock.controller.api;

import com.yvan.gestiondestock.dto.ArticleDto;
import com.yvan.gestiondestock.dto.CategorieDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.yvan.gestiondestock.utils.Constants.APP_ROOT;

public interface CategorieApi {

  @PostMapping(value = APP_ROOT+ "/categorie/create", consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
  CategorieDto save (@RequestBody CategorieDto dto);

  @GetMapping(value = APP_ROOT+"/categorie/{idCategories}",produces = MediaType.APPLICATION_JSON_VALUE)
  CategorieDto findById (@PathVariable("idCategories") Integer id);

  @GetMapping(value = APP_ROOT+"/categorie/{codeCategorie}", produces = MediaType.APPLICATION_JSON_VALUE)
  CategorieDto findByCodeArticle(@PathVariable("codeCategorie") String code);

  @GetMapping(value = APP_ROOT+"/categorie/all", produces = MediaType.APPLICATION_JSON_VALUE)
  List<CategorieDto> findAll();

  @DeleteMapping(APP_ROOT+"/categorie/delete/{idCategorie}")
  void delete (@PathVariable("idCategorie") Integer id);
}
