package com.yvan.gestiondestock.repository;

import com.yvan.gestiondestock.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepo extends JpaRepository<Integer, Roles> {
}
