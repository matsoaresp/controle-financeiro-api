package financeiro.example.financeiro.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import financeiro.example.financeiro.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Movimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double valor;
    @Enumerated(EnumType.STRING)
    private TransactionType type;
    private LocalDateTime timestamp;
    private String descricao;


    @ManyToOne()
    @JoinColumn(name ="usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    @ManyToMany
    @JoinTable(
            name = "transacao_conta",
            joinColumns = @JoinColumn(name = "transacao_id"),
            inverseJoinColumns = @JoinColumn(name = "conta_id")
    )
    @JsonIgnoreProperties("transacoes")
    private List<Conta> contas;
}
