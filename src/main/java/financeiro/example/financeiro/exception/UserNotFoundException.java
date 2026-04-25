package financeiro.example.financeiro.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("Usuario não encontrado");
    }
}
