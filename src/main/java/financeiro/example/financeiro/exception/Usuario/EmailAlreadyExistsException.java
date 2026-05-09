package financeiro.example.financeiro.exception.Usuario;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException() {
        super("Email já existe");
    }

    public EmailAlreadyExistsException(String message){
        super(message);
    }
}
