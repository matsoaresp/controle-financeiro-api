package financeiro.example.financeiro.entity;

import jakarta.persistence.Entity;

@Entity
public class ContaCorrente extends Conta{

    private double limite;
}
