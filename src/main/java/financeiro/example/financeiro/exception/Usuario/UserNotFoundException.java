package financeiro.example.financeiro.exception.Usuario;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("Usuario não encontrado");
    }
}
