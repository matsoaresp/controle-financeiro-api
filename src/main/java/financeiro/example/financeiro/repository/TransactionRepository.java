package financeiro.example.financeiro.repository;

import financeiro.example.financeiro.entity.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transacao, Long> {

}
