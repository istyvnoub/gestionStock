package com.yvan.gestiondestock.controller.api;

import com.yvan.gestiondestock.dto.ArticleDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.yvan.gestiondestock.utils.Constants.APP_ROOT;

public interface ArticleApi {

  @PostMapping(value = APP_ROOT+ "/articles/create", consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
  ArticleDto save (@RequestBody ArticleDto dto);

  @GetMapping(value = APP_ROOT+"/articles/{idArticles}",produces = MediaType.APPLICATION_JSON_VALUE)
  ArticleDto findById (@PathVariable("idArticles") Integer id);

  @GetMapping(value = APP_ROOT+"/articles/{codeArticles}", produces = MediaType.APPLICATION_JSON_VALUE)
  ArticleDto findByCodeArticle(@PathVariable("codeArticles") String codeArticle);

  @GetMapping(value = APP_ROOT+"/articles/all", produces = MediaType.APPLICATION_JSON_VALUE)
  List<ArticleDto> findAll();

  @DeleteMapping(APP_ROOT+"/articles/delete/{idArticles}")
  void delete (@PathVariable("idArticles") Integer id);
}
