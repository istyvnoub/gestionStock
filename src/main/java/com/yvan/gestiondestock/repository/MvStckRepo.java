package com.yvan.gestiondestock.repository;

import com.yvan.gestiondestock.model.MvStck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MvStckRepo extends JpaRepository<MvStck,Integer> {
}
