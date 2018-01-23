package ch.globaz.utilisateursservice.application.service.impl;

import ch.globaz.utilisateursservice.domain.service.UtilisateursService;
import ch.globaz.utilisateursservice.domain.events.UtilisateurCree;
import ch.globaz.utilisateursservice.domain.model.Utilisateur;
import ch.globaz.utilisateursservice.domain.repository.UtilisateursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UtilisateursServiceImpl implements UtilisateursService {


    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;


    @Autowired
    UtilisateursRepository utilisateursRepository;

    @Override
    public Utilisateur creerNouvelUtilisateur(Utilisateur utilisateur) {
        Utilisateur newUtilisateur = utilisateursRepository.sauve(utilisateur);
        applicationEventPublisher.publishEvent(new UtilisateurCree(newUtilisateur));
        return newUtilisateur;
    }

    @Override
    public List<Utilisateur> listeUtilisateurs() {

        return utilisateursRepository.getAll();
    }


    @Override
    public Optional<Utilisateur> getByIdentifiant(Long idenfiant) {

        return utilisateursRepository.getById(idenfiant);
    }
}
