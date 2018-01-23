package ch.globaz.utilisateursservice.domain.model;

public class UtilisateurId {

    private String username;

    public UtilisateurId(String username){
        this.username = username;
    }

    public String asString() {
        return this.username;
    }

    UtilisateurId () {}
}
