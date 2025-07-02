package one.innovation.digital.gof.exceptions;

public class IdAusenteException extends RuntimeException {
    public IdAusenteException() {
      super("O id inserido não está presente no banco de dados");
    }

    public IdAusenteException(String message) {
        super(message);
    }
}
