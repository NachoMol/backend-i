package com.example.clase31.repository;

import com.example.clase31.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoRepository extends JpaRepository<Movimiento,Long> {
}
