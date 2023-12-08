package io.bootify.gestor_biblioteca_v3.domain;

import jakarta.validation.constraints.Size;
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


@Document("lectors")
@Getter
@Setter
public class Lector {

    @Id
    private Long id;

    @Size(max = 255)
    private String nombre;

    @Size(max = 255)
    private String email;

    @Size(max = 255)
    private String telefono;

    @Size(max = 255)
    private String direccion;

    @DocumentReference(lazy = true)
    private Prestamo prestamos;

    @DocumentReference(lazy = true, lookup = "{ 'lectores' : ?#{#self._id} }")
    @ReadOnlyProperty
    private Set<Prestamo> prestamosref;

    @CreatedDate
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    private OffsetDateTime lastUpdated;

    @Version
    private Integer version;

}
