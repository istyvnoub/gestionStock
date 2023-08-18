package com.yvan.gestiondestock.repository;

import com.yvan.gestiondestock.model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseRepo extends JpaRepository<Integer, Entreprise> {
}
