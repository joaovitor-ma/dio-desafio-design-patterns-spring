package one.innovation.digital.gof.infra;

import one.innovation.digital.gof.exceptions.IdAusenteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(IdAusenteException.class)
    private ResponseEntity<MensagemException> idAusenteHandler(IdAusenteException idAusenteException) {
        MensagemException respostaTratada = new MensagemException(HttpStatus.NOT_FOUND, idAusenteException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respostaTratada);
    }
}
