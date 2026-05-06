package financeiro.example.financeiro.exception;

public class AccountDataIncorrect extends RuntimeException {
    public AccountDataIncorrect(String message) {
        super(message);
    }

    public AccountDataIncorrect() {super("Dados Informados Icorretamente");}

}
