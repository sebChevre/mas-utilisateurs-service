package ch.globaz.utilisateursservice.domain.service;

import ch.globaz.utilisateursservice.domain.model.Utilisateur;

import java.util.List;
import java.util.Optional;

public interface UtilisateursService {

    Utilisateur creerNouvelUtilisateur(Utilisateur utilisateur);

    List<Utilisateur> listeUtilisateurs();

    Optional<Utilisateur> getByIdentifiant(Long idenfiant);
}
