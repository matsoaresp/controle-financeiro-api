package financeiro.example.financeiro.entity;

import com.fasterxml.jackson.databind.annotation.EnumNaming;
import financeiro.example.financeiro.enums.TransactionStatus;
import financeiro.example.financeiro.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private LocalDateTime timestamp;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @ManyToOne()
    @JoinColumn(name ="usuario_id", referencedColumnName = "id" )
    private Usuario usuario;


}
