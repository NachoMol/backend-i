package com.dh.DirectoresYJugadores.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "directores_tecnicos")
@Getter
@Setter
public class DirectorTecnico {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   @Column
   private String nombre;
   @Column
   private Integer edad;
   @OneToMany(mappedBy = "directorTecnico", fetch = FetchType.LAZY)
   private Set<Jugador> jugadores= new HashSet<>();

}
