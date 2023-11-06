package com.yvan.gestiondestock.repository;

import com.yvan.gestiondestock.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepo extends JpaRepository<Categorie,Integer> {
}
