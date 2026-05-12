package financeiro.example.financeiro.exception.Movimento;

public class MovementNotFoundException extends RuntimeException {
    public MovementNotFoundException(String message) {
        super(message);
    }
    public MovementNotFoundException () {super("Movimento não encontrado");}
}
