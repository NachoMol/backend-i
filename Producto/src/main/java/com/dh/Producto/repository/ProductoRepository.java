package com.dh.Producto.repository;

import com.dh.Producto.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto,Integer> {

    @Query("SELECT p FROM Producto p where p.cantidad > 0")
    List<Producto> productosConStock();

}
