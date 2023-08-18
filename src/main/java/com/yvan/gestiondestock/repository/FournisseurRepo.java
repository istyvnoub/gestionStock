package com.yvan.gestiondestock.repository;

import com.yvan.gestiondestock.model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepo extends JpaRepository<Integer, Fournisseur> {
}
