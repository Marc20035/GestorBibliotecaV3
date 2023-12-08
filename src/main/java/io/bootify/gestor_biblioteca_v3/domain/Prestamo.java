package io.bootify.gestor_biblioteca_v3.domain;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;


@Document("prestamoes")
@Getter
@Setter
public class Prestamo {

    @Id
    private Long id;

    private LocalDate fechaPrestamo;

    private LocalDate fechaDevolucionReal;

    private LocalDate fechaDevolucionPrevista;

    @DocumentReference(lazy = true)
    private Libro libro;

    @DocumentReference(lazy = true, lookup = "{ 'prestamos' : ?#{#self._id} }")
    @ReadOnlyProperty
    private Set<Lector> lector;

    @DocumentReference(lazy = true)
    private Lector lectores;

    @CreatedDate
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    private OffsetDateTime lastUpdated;

    @Version
    private Integer version;

}
