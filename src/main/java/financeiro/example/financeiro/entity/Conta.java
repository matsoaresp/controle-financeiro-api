package financeiro.example.financeiro.entity;

import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double saldo;
    @ManyToOne()
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
