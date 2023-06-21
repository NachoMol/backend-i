package com.example.clase38.repository;

import com.example.clase38.entities.Partido;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PartidoRepository extends MongoRepository<Partido,Long> {
}
