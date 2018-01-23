package ch.globaz.utilisateursservice.domain.events;

import ch.globaz.utilisateursservice.domain.model.EtatUtilisateur;
import ch.globaz.utilisateursservice.domain.model.Utilisateur;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;

public class UtilisateurCree implements EvenementDomaine{

    private String nomUtilisateur;
    private Long utilisateurId;
    private Long personneId;
    private EtatUtilisateur etatUtilisateur;
    private Date creationDate;

    public UtilisateurCree () {}

    public UtilisateurCree(Utilisateur utilisateur) {
        this.nomUtilisateur = utilisateur.userId().asString();
        this.utilisateurId = utilisateur.id();
        this.personneId = utilisateur.personneId();
        this.etatUtilisateur = utilisateur.etatUtilisateur();
        this.creationDate = new Date();
    }




}
