package financeiro.example.financeiro.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;

    private String agencia;

    private String banco;

    private double saldo;

    private String tipoConta;

    @ManyToOne()
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    @ManyToMany(mappedBy = "contas")
    @JsonIgnoreProperties("contas")
    private List<Transacao> transacoes;

}
