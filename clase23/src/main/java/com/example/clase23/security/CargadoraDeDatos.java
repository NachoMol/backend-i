package com.example.clase23.security;

import com.example.clase23.entities.AppUsuario;
import com.example.clase23.entities.AppUsuarioRole;
import com.example.clase23.service.AppUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CargadoraDeDatos implements ApplicationRunner {

    private AppUsuarioService appUsuarioService;
    @Autowired
    public CargadoraDeDatos(AppUsuarioService appUsuarioService) {
        this.appUsuarioService = appUsuarioService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
        String passUser="password";
        String passAdmin="admin";
        String passCifrada=passwordEncoder.encode(passUser);
        String passCifradaAdmin=passwordEncoder.encode(passAdmin);
        appUsuarioService.guardarUsuario(new AppUsuario("Usuario","Usuario","usuario@gmail.com",passCifrada, AppUsuarioRole.ROLE_USER));
        appUsuarioService.guardarUsuario(new AppUsuario("Admin","Admin","admin@gmail.com",passCifradaAdmin, AppUsuarioRole.ROLE_ADMIN));
    }
}
