package com.example.clase23.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="odontologos")
@Getter
@Setter
@AllArgsConstructor
public class Odontologo {
    public Odontologo() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column(unique = true, nullable = false)
    private String matricula;

    @OneToMany(mappedBy = "odontologo",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Turno> turnos;
}
