package io.bootify.gestor_biblioteca_v3.repos;

import io.bootify.gestor_biblioteca_v3.domain.Libro;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface LibroRepository extends MongoRepository<Libro, Long> {
}
