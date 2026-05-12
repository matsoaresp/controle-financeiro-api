package financeiro.example.financeiro.exception.Conta;

public class AccountSmallerValues extends RuntimeException {


    public AccountSmallerValues(String message) {
        super(message);
    }
    public AccountSmallerValues () {super("O saldo não pode ser menor que o valor sacado");}
}
