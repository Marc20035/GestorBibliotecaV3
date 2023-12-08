package io.bootify.gestor_biblioteca_v3.repos;

import io.bootify.gestor_biblioteca_v3.domain.Auditoria;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface AuditoriaRepository extends MongoRepository<Auditoria, Long> {
}
