package financeiro.example.financeiro.infra;

import financeiro.example.financeiro.exception.AccountValueException;
import financeiro.example.financeiro.exception.EmailAlreadyExistsException;
import financeiro.example.financeiro.exception.UserFullException;
import financeiro.example.financeiro.exception.UserNotFoundException;
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
    private ResponseEntity<String> accountValueHandler(AccountValueException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Saldo não pode ser negativo");
    }
}
