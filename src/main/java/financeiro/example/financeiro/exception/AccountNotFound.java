package financeiro.example.financeiro.exception;

public class AccountNotFound extends RuntimeException {
    public AccountNotFound(String message) {
        super(message);
    }
    public AccountNotFound() {super("Conta não encontrada");}
}
