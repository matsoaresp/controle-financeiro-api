package financeiro.example.financeiro.infra;

import financeiro.example.financeiro.exception.Conta.AccountDataIncorrect;
import financeiro.example.financeiro.exception.Conta.AccountNotFound;
import financeiro.example.financeiro.exception.Conta.AccountValueException;
import financeiro.example.financeiro.exception.Usuario.EmailAlreadyExistsException;
import financeiro.example.financeiro.exception.Usuario.UserFullException;
import financeiro.example.financeiro.exception.Usuario.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<String> userNotFoundHandler(UserNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Usuário não encontrado");
    }

    @ExceptionHandler(UserFullException.class)
    private ResponseEntity<String> userFullHandler(UserFullException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Usuário já cadastrado");
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    private ResponseEntity<String> emailExistsHandler(EmailAlreadyExistsException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Email já existe");
    }

    @ExceptionHandler(AccountValueException.class)
    private ResponseEntity<String> AccountValueHandler(AccountValueException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Saldo não pode ser negativo");
    }
    @ExceptionHandler(AccountDataIncorrect.class)
    private ResponseEntity<String> AccountIncorrectHandler(AccountDataIncorrect exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Dados Informados incorretamente");
    }
    @ExceptionHandler(AccountNotFound.class)
    private ResponseEntity<String> AccountNotFoundHandler(AccountNotFound exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Conta não eEncontrada");
    }
}
