package ch.globaz.utilisateursservice.application.api.web;

import ch.globaz.utilisateursservice.application.api.exception.RessourceNotFoundException;
import ch.globaz.utilisateursservice.application.api.exception.RessourceExceptionBody;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class UtilisateursControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { RessourceNotFoundException.class })
    protected ResponseEntity<Object> handleNoHandlerFoundException(RuntimeException ex, WebRequest request) {


        Long idRessource = ((RessourceNotFoundException)ex).ressourceId();
        String path = ((RessourceNotFoundException)ex).path();

        RessourceExceptionBody body = new RessourceExceptionBody(LocalDateTime.now(),
                HttpStatus.NOT_FOUND,ex,String.format("No user found with id:%s",idRessource),path);

        //return handleExceptionInternal(ex, body,
        //        new HttpHeaders(), HttpStatus.NOT_FOUND, request);

        return handleExceptionInternal(ex, body,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    /**
    {
        "timestamp":1461621047967,
            "status":404,
            "error":"Not Found",
            "exception":"NotFoundException",
            "message":"No message available",
            "path":"/greet"
    }*/

}
