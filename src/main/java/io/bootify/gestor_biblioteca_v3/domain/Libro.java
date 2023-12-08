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


@Document("libroes")
@Getter
@Setter
public class Libro {

    @Id
    private Long id;

    @Size(max = 255)
    private String titulo;

    @Size(max = 255)
    private String autor;

    @Size(max = 255)
    private String isbn;

    private Integer anioPublicacion;

    @Size(max = 255)
    private String editorial;

    @Size(max = 255)
    private String categoria;

    @DocumentReference(lazy = true, lookup = "{ 'libro' : ?#{#self._id} }")
    @ReadOnlyProperty
    private Set<Prestamo> prestamos;

    @CreatedDate
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    private OffsetDateTime lastUpdated;

    @Version
    private Integer version;

}
