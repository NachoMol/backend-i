package com.example.clase23.security;

import com.example.clase23.entities.Usuario;
import com.example.clase23.entities.UsuarioRole;
import com.example.clase23.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatosInicalesUsuarios implements ApplicationRunner {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder cifrador= new BCryptPasswordEncoder();
        String passSinCifrar="admin";
        String passCifrado= cifrador.encode(passSinCifrar);
        String passSinCifrar2="user";
        String passCifrado2= cifrador.encode(passSinCifrar2);
        Usuario usuarioAInsertarADMIN= new Usuario("jorgito","jpereyradh","admin@digitalhouse.com",passCifrado, UsuarioRole.ROLE_ADMIN);
        System.out.println("La contraseña cifrada es la siguiente::::::::"+passCifrado);
        usuarioRepository.save(usuarioAInsertarADMIN);
        Usuario usuarioAInsertarUSER= new Usuario("jorgito","jpereyradh","user@digitalhouse.com",passCifrado2, UsuarioRole.ROLE_USER);
        System.out.println("La contraseña cifrada es la siguiente::::::::"+passCifrado2);
        usuarioRepository.save(usuarioAInsertarUSER);
    }
}
