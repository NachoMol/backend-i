package com.dh.Producto.service;

import com.dh.Producto.entity.Producto;
import com.dh.Producto.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;
    public Producto guardarProducto(Producto producto){
        return productoRepository.save(producto);
    }
}
