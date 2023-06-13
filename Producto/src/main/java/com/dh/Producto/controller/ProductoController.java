package com.dh.Producto.controller;

import com.dh.Producto.entity.Producto;
import com.dh.Producto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;
    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto){
        return ResponseEntity.ok(productoService.guardarProducto(producto));
    }

    @GetMapping("/conStock")
    public ResponseEntity<List<?>> listarConStock(){
        return ResponseEntity.ok().body(productoService.productosConStock());
    }
}
