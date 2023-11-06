package com.yvan.gestiondestock.repository;

import com.yvan.gestiondestock.model.LigneVente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneVenteRepo extends JpaRepository<LigneVente,Integer> {
}
