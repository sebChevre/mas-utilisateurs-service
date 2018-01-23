package ch.globaz.utilisateursservice.application.events;

import ch.globaz.utilisateursservice.domain.events.EvenementDomaine;
import ch.globaz.utilisateursservice.domain.events.UtilisateurCree;
import ch.globaz.utilisateursservice.domain.model.Utilisateur;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UtilisateursEventsListener {

    private static final Logger logger = LoggerFactory.getLogger(UtilisateursEventsListener.class.getName());

    @Autowired
    ObjectMapper mapper;

    @EventListener
    public void listenUtilisateurCree(UtilisateurCree evenement) throws JsonProcessingException {
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        logger.info(mapper.writeValueAsString(evenement));
    }


}
