package io.bootify.gestor_biblioteca_v3.domain;

import jakarta.validation.constraints.Size;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("auditorias")
@Getter
@Setter
public class Auditoria {

    @Id
    private Long id;

    @Size(max = 255)
    private String accion;

    private LocalTime fechaHora;

    @Size(max = 255)
    private String usuarioResponsable;

    @Size(max = 255)
    private String detalles;

    @CreatedDate
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    private OffsetDateTime lastUpdated;

    @Version
    private Integer version;

}
