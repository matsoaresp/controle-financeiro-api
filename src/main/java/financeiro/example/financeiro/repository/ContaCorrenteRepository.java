package financeiro.example.financeiro.repository;

import financeiro.example.financeiro.entity.ContaCorrente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Long> {
}
