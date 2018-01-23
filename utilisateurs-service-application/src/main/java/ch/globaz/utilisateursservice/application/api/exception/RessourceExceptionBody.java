package ch.globaz.utilisateursservice.application.api.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class RessourceExceptionBody {

    private String isoDate;
    private int status;
    private String error;
    private String exception;
    private String message;
    private String path;


    public RessourceExceptionBody(LocalDateTime date, HttpStatus status, Exception exception, String message, String path) {
        this.isoDate = date.format(DateTimeFormatter.ISO_DATE_TIME);
        this.status = status.value();
        this.error = status.getReasonPhrase();
        this.exception = exception.getClass().getName();
        this.message = message;
        this.path = path;
    }

    public String getIsoDate() {
        return isoDate;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getException() {
        return exception;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    /**
    "timestamp":1461621047967,
            "status":404,
            "error":"Not Found",
            "exception":"NotFoundException",
            "message":"No message available",
            "path":"/greet"
     */

}
