package ch.globaz.utilisateursservice.domain.repository;

import ch.globaz.utilisateursservice.domain.model.Utilisateur;

import java.util.List;
import java.util.Optional;

public interface UtilisateursRepository {

    Utilisateur sauve(Utilisateur utilisateur);

    List<Utilisateur> getAll();

    Optional<Utilisateur> getById(Long id);
}
