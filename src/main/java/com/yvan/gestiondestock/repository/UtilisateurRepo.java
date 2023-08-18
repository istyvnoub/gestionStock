package com.yvan.gestiondestock.repository;

import com.yvan.gestiondestock.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepo extends JpaRepository<Integer, Utilisateur> {
}
