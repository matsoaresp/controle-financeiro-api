package financeiro.example.financeiro.entity;

import financeiro.example.financeiro.enums.TransactionStatus;
import financeiro.example.financeiro.enums.TransactionType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TransactionType type;
    private LocalDateTime timestamp;
    private String descricao;
    private TransactionStatus status;

}
