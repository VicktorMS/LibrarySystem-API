package vicktorms.br.infnet.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String mensagem) {
        super(mensagem);
    }
}
