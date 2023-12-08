package io.bootify.gestor_biblioteca_v3.repos;

import io.bootify.gestor_biblioteca_v3.domain.Bibliotecario;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface BibliotecarioRepository extends MongoRepository<Bibliotecario, Long> {
}
