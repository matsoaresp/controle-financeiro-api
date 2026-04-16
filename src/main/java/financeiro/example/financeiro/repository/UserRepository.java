package financeiro.example.financeiro.repository;
import financeiro.example.financeiro.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {

    boolean existsByEmail(String email);

}
