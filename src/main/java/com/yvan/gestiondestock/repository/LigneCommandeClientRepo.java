package com.yvan.gestiondestock.repository;

import com.yvan.gestiondestock.model.LigneCommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LigneCommandeClientRepo extends JpaRepository<LigneCommandeClient,Integer> {
  List<LigneCommandeClient> findAllByCommandeClientId(Integer id);
  }
