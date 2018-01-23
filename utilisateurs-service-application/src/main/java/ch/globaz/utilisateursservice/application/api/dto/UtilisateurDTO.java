package ch.globaz.utilisateursservice.application.api.dto;

import ch.globaz.utilisateursservice.domain.model.EtatUtilisateur;
import ch.globaz.utilisateursservice.domain.model.Utilisateur;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.hateoas.ResourceSupport;

public class UtilisateurDTO extends ResourceSupport{

    private String nomUtilisateur;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String motDePasse;

    private Long utilisateursId;

    private Long personneId;

    private EtatUtilisateur etatUtilisateur;

    //pour jackson
    public UtilisateurDTO () {}

    private UtilisateurDTO(Long utilisateursId, String nomUtilisateur, Long personneId, EtatUtilisateur etatUtilisateur) {
        this.utilisateursId = utilisateursId;
        this.nomUtilisateur = nomUtilisateur;
        this.personneId = personneId;
        this.etatUtilisateur = etatUtilisateur;
    }

    private UtilisateurDTO(Long utilisateursId, String nomUtilisateur, String motDePasse, Long personneId, EtatUtilisateur etatUtilisateur) {
        this.utilisateursId = utilisateursId;
        this.nomUtilisateur = nomUtilisateur;
        this.personneId = personneId;
        this.etatUtilisateur = etatUtilisateur;
        this.motDePasse = motDePasse;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public Long getUtilisateursId() {
        return utilisateursId;
    }

    public Long getPersonneId() {
        return personneId;
    }

    public EtatUtilisateur getEtatUtilisateur () {
        return etatUtilisateur;
    }

    public static UtilisateurDTO fromEntity(Utilisateur utilisateur){

        return new UtilisateurDTO(utilisateur.id(),utilisateur.userId().asString(),utilisateur.personneId(),utilisateur.etatUtilisateur());
    }

}
