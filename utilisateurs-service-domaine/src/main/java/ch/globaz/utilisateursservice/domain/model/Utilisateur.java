package ch.globaz.utilisateursservice.domain.model;

public class Utilisateur {

    private Long id;

    private String motDePasse;
    private Long personneId;
    private UtilisateurId userId;
    private EtatUtilisateur etatUtilisateur;



    private Utilisateur(String nom, String motDePasse, Long personneId) {
        this.motDePasse = motDePasse;
        this.personneId = personneId;
        this.userId = new UtilisateurId(nom);
        this.etatUtilisateur = EtatUtilisateur.INITIE;
    }

    public static Utilisateur from(String nom, String motDePasse, Long personneId) {
        Utilisateur u = new Utilisateur(nom, motDePasse,personneId);
        return u;
    }

    public Long id() {
        return id;
    }


    public String motDePasse() {
        return motDePasse;
    }

    public Long personneId() {
        return personneId;
    }

    public UtilisateurId userId () {
        return userId;
    }

    public EtatUtilisateur etatUtilisateur() {
        return etatUtilisateur;
    }

    public void activer() {

        this.etatUtilisateur = EtatUtilisateur.ACTIF;
    }

    public void desactiver() {

        this.etatUtilisateur = EtatUtilisateur.INACTIF;
    }

    Utilisateur(){ }

}
