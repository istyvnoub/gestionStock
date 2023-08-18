package com.yvan.gestiondestock.repository;

import com.yvan.gestiondestock.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Integer, Client> {
}
