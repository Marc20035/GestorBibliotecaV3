package io.bootify.gestor_biblioteca_v3.repos;

import io.bootify.gestor_biblioteca_v3.domain.Administrador;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface AdministradorRepository extends MongoRepository<Administrador, Long> {
}
