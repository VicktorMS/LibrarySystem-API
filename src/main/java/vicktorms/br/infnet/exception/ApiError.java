package vicktorms.br.infnet.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ApiError {

    private final HttpStatus status;
    private final String mensagem;
    private final LocalDateTime timestamp;

    public ApiError(HttpStatus status, String mensagem, LocalDateTime timestamp) {
        this.status = status;
        this.mensagem = mensagem;
        this.timestamp = timestamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
