package com.dh.DirectoresYJugadores.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "jugadores")
@Getter
@Setter
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private String clubFavorito;
    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private DirectorTecnico directorTecnico;
}
