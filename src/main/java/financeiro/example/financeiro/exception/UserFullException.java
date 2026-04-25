package financeiro.example.financeiro.exception;

public class UserFullException extends RuntimeException {
    public UserFullException() {
        super("Usuario já cadastrado");
    }

    public UserFullException(String message){
        super(message);
    }
}
