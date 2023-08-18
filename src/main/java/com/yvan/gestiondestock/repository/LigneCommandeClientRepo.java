package com.yvan.gestiondestock.repository;

import com.yvan.gestiondestock.model.LigneCommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandeClientRepo extends JpaRepository<Integer, LigneCommandeClient> {
  }
