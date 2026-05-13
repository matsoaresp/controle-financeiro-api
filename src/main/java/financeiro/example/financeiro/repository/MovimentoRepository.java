package financeiro.example.financeiro.repository;

import financeiro.example.financeiro.entity.Movimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentoRepository extends JpaRepository<Movimento, Long> {

}
