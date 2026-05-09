package financeiro.example.financeiro.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    @JsonIgnore
    private String senha;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Conta> contas ;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Transacao> transacoes;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario() {

    }

}
