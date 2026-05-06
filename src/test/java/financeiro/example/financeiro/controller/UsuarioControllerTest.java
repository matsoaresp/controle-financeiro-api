package financeiro.example.financeiro.controller;

import financeiro.example.financeiro.dto.RequestUserDto;
import financeiro.example.financeiro.entity.Usuario;
import financeiro.example.financeiro.exception.EmailAlreadyExistsException;
import financeiro.example.financeiro.repository.UsuarioRepository;
import financeiro.example.financeiro.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UsuarioControllerTest {

    @Mock
    private UsuarioRepository repository;

    @InjectMocks
    private UsuarioService service;

    @Test
    void deveCriarUsuario() {

        RequestUserDto dto = new RequestUserDto();
        dto.setEmail("maateussp@gmail.com");
        dto.setPassword("123456");

        when(repository.existsByEmail(dto.getEmail())).thenReturn(false);

        Usuario usuarioSalvo = new Usuario(dto.getNome(), dto.getEmail(), dto.getPassword());
        when(repository.save(any())).thenReturn(usuarioSalvo);

        Usuario result = service.create(dto);

        assertEquals("maateussp@gmail.com", result.getEmail());
    }

    @Test
    void deveLancarExcecao() {

        Long id = 1L;
        Usuario usuario = new Usuario();

        usuario.setId(id);
        usuario.setEmail("maateussp@gmail.com");
        usuario.setSenha("123456");

        when(repository.findById(id)).thenReturn(Optional.of(usuario));
        when(repository.existsByEmail("jose@gmail.com")).thenReturn(true);

        RequestUserDto dto = new RequestUserDto();
        dto.setEmail("jose@gmail.com");
        assertThrows(EmailAlreadyExistsException.class, () -> {
            service.update(id, dto);
        });
        verify(repository, never()).save(any());
    }

    @Test
    void deveAtualizarUsuario() {

        Long id = 1L;
        Usuario usuario = new Usuario();

        usuario.setId(id);
        usuario.setEmail("maateussp@gmail.com");
        usuario.setSenha("123456");

        when(repository.findById(id)).thenReturn(Optional.of(usuario));
        when(repository.existsByEmail("jose@gmail.com")).thenReturn(true);

        RequestUserDto dto = new RequestUserDto();
        dto.setEmail("jose@gmail.com");
        service.update(id, dto);

        verify(repository).save(any());
    }

    @Test
    void deveDeletarUsuario() {
        Long id = 1L;
        when(repository.existsById(id)).thenReturn(true);
        service.delete(id);
        verify(repository).deleteById(id);

    }

    @Test
    void deveRetornarUmUsuario() {

        Long id = 1L;

        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setEmail("teste@gmail.com");
        when(repository.findById(id))
                .thenReturn(Optional.of(usuario));
        Usuario result = service.findOne(id);
        assertEquals(id, result.getId());
        verify(repository).findById(id);
    }

    @Test
    void findAll() {

        List<Usuario> lista = new ArrayList<>();

        Usuario u1 = new Usuario();
        u1.setEmail("teste1@gmail.com");

        Usuario u2 = new Usuario();
        u2.setEmail("teste2@gmail.com");

        lista.add(u1);
        lista.add(u2);

        when(repository.findAll()).thenReturn(lista);

        List<Usuario> resultado = service.findAll();

        verify(repository).findAll();

        assertEquals(2, resultado.size());
    }




}