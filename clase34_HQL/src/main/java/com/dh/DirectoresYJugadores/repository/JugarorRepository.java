package com.dh.DirectoresYJugadores.repository;

import com.dh.DirectoresYJugadores.entities.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugarorRepository extends JpaRepository<Jugador,Long> {
}
