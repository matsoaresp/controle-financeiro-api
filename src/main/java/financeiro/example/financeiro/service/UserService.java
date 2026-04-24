package financeiro.example.financeiro.service;

import financeiro.example.financeiro.dto.RequestUserDto;
import financeiro.example.financeiro.dto.ResponseUserDto;
import financeiro.example.financeiro.entity.Usuario;
import financeiro.example.financeiro.exception.EmailAlreadyExistsException;
import financeiro.example.financeiro.exception.UserNotFoundException;
import financeiro.example.financeiro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Usuario create (RequestUserDto dto){
        Usuario usuario = new Usuario(
                dto.getEmail(),
                dto.getPassword()
        );

        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new EmailAlreadyExistsException();
        }
        return userRepository.save(usuario);
    }

    public Usuario findById(Long id){
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public List<Usuario> findAll () {
        return userRepository.findAll();
    }

    public ResponseUserDto update (Long id, RequestUserDto dto) {
        Usuario usuario = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        if(!dto.getEmail().equals(usuario.getEmail()) &&
            userRepository.existsByEmail(dto.getEmail())) {
            throw new EmailAlreadyExistsException();
        }
        usuario.setEmail(dto.getEmail());

        Usuario updated = userRepository.save(usuario);
        return new ResponseUserDto(updated.getId(), updated.getEmail());
    }

    public void delete (Long id) {
        if (!userRepository.existsById(id)
        ) {
            throw new UserNotFoundException();
        }
        userRepository.deleteById(id);
    }
}
