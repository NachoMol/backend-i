package com.example.clase23.repository;

import com.example.clase23.entities.AppUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUsuario,Long> {
    Optional<AppUsuario> findByEmail(String email);
}
