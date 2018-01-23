package ch.globaz.utilisateursservice.application.api.exception;

public class RessourceNotFoundException extends RuntimeException {

    private Long ressourceId;
    private String path;

    public RessourceNotFoundException(String msg, Long ressourceId, String requestURI) {
        super(msg);
        this.ressourceId = ressourceId;
        this.path = requestURI;
    }

    public Long ressourceId(){
        return ressourceId;
    }

    public String path() {
        return path;
    }
}
