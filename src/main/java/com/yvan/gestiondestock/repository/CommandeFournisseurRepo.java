package com.yvan.gestiondestock.repository;

import com.yvan.gestiondestock.model.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommandeFournisseurRepo extends JpaRepository<CommandeFournisseur, Integer> {



  Optional <CommandeFournisseur> findCommandeFournisseurByCode(String code);
}
