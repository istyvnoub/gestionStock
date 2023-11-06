package com.yvan.gestiondestock.repository;

import com.yvan.gestiondestock.model.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommandeClientRepo extends JpaRepository< CommandeClient ,Integer > {
  List<CommandeClient> findAllByClientId(Integer id);
}
