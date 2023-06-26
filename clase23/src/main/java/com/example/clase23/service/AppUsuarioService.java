package com.example.clase23.service;

import com.example.clase23.entities.AppUsuario;
import com.example.clase23.repository.OdontologoRepository;
import com.example.clase23.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class AppUsuarioService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUsuario> usuarioBuscado = userRepository.findByEmail(username);

        if(usuarioBuscado.isPresent()){
            return usuarioBuscado.get();
        }else{
            throw new UsernameNotFoundException("Usuario/a no encontrado. Email: " + username);
        }

    }

    public AppUsuario guardarUsuario(AppUsuario appUsuario){
        return userRepository.save(appUsuario);
    }
}
