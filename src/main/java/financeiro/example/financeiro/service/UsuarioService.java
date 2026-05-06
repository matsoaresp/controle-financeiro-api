package financeiro.example.financeiro.service;

import financeiro.example.financeiro.dto.RequestUserDto;
import financeiro.example.financeiro.dto.ResponseUserDto;
import financeiro.example.financeiro.entity.Usuario;
import financeiro.example.financeiro.exception.EmailAlreadyExistsException;
import financeiro.example.financeiro.exception.UserNotFoundException;
import financeiro.example.financeiro.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario create (RequestUserDto dto){
        Usuario usuario = new Usuario(
                dto.getNome(),
                dto.getEmail(),
                dto.getPassword()
        );
        if (usuarioRepository.existsByEmail(dto.getEmail())) {
            throw new EmailAlreadyExistsException();
        }
        return usuarioRepository.save(usuario);
    }

    public Usuario findOne(Long id){
        return usuarioRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public List<Usuario> findAll () {
        return usuarioRepository.findAll();
    }

    public ResponseUserDto update (Long id, RequestUserDto dto) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(UserNotFoundException::new);
        if(!dto.getEmail().equals(usuario.getEmail()) &&
            usuarioRepository.existsByEmail(dto.getEmail())) {
            throw new EmailAlreadyExistsException();
        }
        usuario.setEmail(dto.getEmail());

        Usuario updated = usuarioRepository.save(usuario);
        return new ResponseUserDto(updated.getId(), updated.getEmail());
    }

    public void delete (Long id) {
        if (!usuarioRepository.existsById(id)
        ) {
            throw new UserNotFoundException();
        }
        usuarioRepository.deleteById(id);
    }
}
