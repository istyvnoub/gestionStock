package com.yvan.gestiondestock.repository;

import com.yvan.gestiondestock.model.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeClientRepo extends JpaRepository<Integer, CommandeClient> {
}
