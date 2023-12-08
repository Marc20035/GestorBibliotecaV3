package io.bootify.gestor_biblioteca_v3.repos;

import io.bootify.gestor_biblioteca_v3.domain.Lector;
import io.bootify.gestor_biblioteca_v3.domain.Prestamo;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface LectorRepository extends MongoRepository<Lector, Long> {

    Lector findFirstByPrestamos(Prestamo prestamo);

}
