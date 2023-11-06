package com.yvan.gestiondestock.services;

import com.yvan.gestiondestock.dto.ArticleDto;
import com.yvan.gestiondestock.dto.CategorieDto;

import java.util.List;

public interface CategorieService {

  CategorieDto save (CategorieDto dto);

  CategorieDto findById (Integer id);

  CategorieDto findByCode(String code);

  List<CategorieDto> findAll();

  void delete (Integer id);
}
