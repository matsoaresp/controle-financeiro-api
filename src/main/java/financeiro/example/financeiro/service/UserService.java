package financeiro.example.financeiro.service;

import financeiro.example.financeiro.dto.RequestUserDto;
import financeiro.example.financeiro.dto.ResponseUserDto;
import financeiro.example.financeiro.entity.Usuario;
import financeiro.example.financeiro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Usuario create (RequestUserDto dto) throws Exception {
        Usuario usuario = new Usuario(
                dto.getEmail(),
                dto.getPassword()
        );

        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new Exception("Email já cadastrado");
        }
        return userRepository.save(usuario);
    }

    public Usuario findById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
    }

    public List<Usuario> findAll () {
        return userRepository.findAll();
    }

    public ResponseUserDto update (Long id, RequestUserDto dto) throws Exception {
        Usuario usuario = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        if(!dto.getEmail().equals(usuario.getEmail()) &&
            userRepository.existsByEmail(dto.getEmail())) {
            throw new Exception ("Email já cadastrado");
        }
        usuario.setEmail(dto.getEmail());

        Usuario updated = userRepository.save(usuario);
        return new ResponseUserDto(updated.getId(), updated.getEmail());
    }

    public void delete (Long id) throws Exception {
        if (userRepository.existsById(id)
        ) {
            throw new Exception("Usuario não encontrado");
        }
        userRepository.deleteById(id);
    }
}
