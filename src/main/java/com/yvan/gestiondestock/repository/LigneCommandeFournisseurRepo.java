package com.yvan.gestiondestock.repository;

import com.yvan.gestiondestock.model.LigneCommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandeFournisseurRepo extends JpaRepository<LigneCommandeFournisseur,Integer > {
}
