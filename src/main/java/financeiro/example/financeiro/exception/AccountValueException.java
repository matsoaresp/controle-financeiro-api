package financeiro.example.financeiro.exception;

public class AccountValueException extends RuntimeException {
    public AccountValueException(String message) {
        super(message);
    }

    public AccountValueException(){super("Saldo não deve ser negativo");}
}
