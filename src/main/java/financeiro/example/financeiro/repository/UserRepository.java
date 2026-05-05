package financeiro.example.financeiro.repository;

import financeiro.example.financeiro.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<Users, Long> {

   UserDetails findByLogin (String login);
}
