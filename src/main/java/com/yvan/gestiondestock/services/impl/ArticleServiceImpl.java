package com.yvan.gestiondestock.services.impl;

import com.yvan.gestiondestock.dto.ArticleDto;
import com.yvan.gestiondestock.exception.EntittyNotFoundException;
import com.yvan.gestiondestock.exception.ErrorCode;
import com.yvan.gestiondestock.exception.InvalidEntittyException;
import com.yvan.gestiondestock.model.Article;
import com.yvan.gestiondestock.repository.ArticleRepository;
import com.yvan.gestiondestock.services.ArticleService;
import com.yvan.gestiondestock.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

  private ArticleRepository articleRepository;

  @Autowired
  public ArticleServiceImpl(ArticleRepository articleRepository){
    this.articleRepository = articleRepository;

  }
  @Override
  public ArticleDto save(ArticleDto dto) {

    List<String> errors = ArticleValidator.validate(dto);
    if(!errors.isEmpty()){
     log.error("Article is not valid {}",dto);
     throw new InvalidEntittyException("L'article nest pas valide", ErrorCode.ARTICLE_NOT_VALID,errors);
    }

    return ArticleDto.fromEntity(articleRepository.save(ArticleDto.toEntity(dto)));
  }

  @Override
  public ArticleDto findByCodeArticle(String codeArticle) {

    return null;
  }

  @Override
  public ArticleDto findById(Integer id) {
    if (id == null){
      log.error("Article ID is null");

    }

    Optional<Article> article = articleRepository.findById(id);



    return Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(()->
      new EntittyNotFoundException(
        "Aucun article avec l'ID =" + id+ " n'ete trouve dns la BD"));

  }

  @Override
  public List<ArticleDto> findAll() {
    return null;
  }

  @Override
  public void delete(Integer id) {
    if (id == null){
      log.error("Article ID is null");

    }
    articleRepository.deleteById(id);

  }
}
