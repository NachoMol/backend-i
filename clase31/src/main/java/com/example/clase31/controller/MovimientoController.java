package com.example.clase31.controller;

import com.example.clase31.entity.Movimiento;
import com.example.clase31.service.MovimientoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {
    private MovimientoService movimientoService;

    public MovimientoController(MovimientoService movimientoService) {
        this.movimientoService = movimientoService;
    }

    @PostMapping
    public ResponseEntity<Movimiento> registrarMovimiento(@RequestBody Movimiento movimiento){
        return ResponseEntity.ok(movimientoService.registrarMovimiento(movimiento));
    }

    @GetMapping ResponseEntity<List<Movimiento>> buscarMovimientos(){
        return ResponseEntity.ok(movimientoService.listarMovimientos());
    }
}
