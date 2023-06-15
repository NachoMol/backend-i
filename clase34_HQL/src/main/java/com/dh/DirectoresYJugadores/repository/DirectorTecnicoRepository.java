package com.dh.DirectoresYJugadores.repository;

import com.dh.DirectoresYJugadores.entities.DirectorTecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DirectorTecnicoRepository  extends JpaRepository<DirectorTecnico,Long> {
    @Query("SELECT dt FROM DirectorTecnico dt WHERE dt.nombre=?1")
    Optional<DirectorTecnico> buscarTecnicoPorNombre(String nombre);
    List<DirectorTecnico> findByEdadGreaterThan(Integer edad);
}
