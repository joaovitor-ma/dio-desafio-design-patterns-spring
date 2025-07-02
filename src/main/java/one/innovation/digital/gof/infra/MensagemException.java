package one.innovation.digital.gof.infra;

import org.springframework.http.HttpStatus;

public class MensagemException {
    private HttpStatus status;
    private String mensagem;

    public MensagemException(HttpStatus status, String mensagem) {
        this.status = status;
        this.mensagem = mensagem;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
