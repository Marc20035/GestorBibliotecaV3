package io.bootify.gestor_biblioteca_v3.repos;

import io.bootify.gestor_biblioteca_v3.domain.Auditoria;
import io.bootify.gestor_biblioteca_v3.service.PrimarySequenceService;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;


@Component
public class AuditoriaListener extends AbstractMongoEventListener<Auditoria> {

    private final PrimarySequenceService primarySequenceService;

    public AuditoriaListener(final PrimarySequenceService primarySequenceService) {
        this.primarySequenceService = primarySequenceService;
    }

    @Override
    public void onBeforeConvert(final BeforeConvertEvent<Auditoria> event) {
        if (event.getSource().getId() == null) {
            event.getSource().setId(primarySequenceService.getNextValue());
        }
    }

}
