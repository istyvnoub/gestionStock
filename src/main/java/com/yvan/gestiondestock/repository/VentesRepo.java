package com.yvan.gestiondestock.repository;

import com.yvan.gestiondestock.model.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentesRepo extends JpaRepository<Ventes,Integer> {
}
