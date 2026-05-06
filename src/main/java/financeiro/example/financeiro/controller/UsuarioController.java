package financeiro.example.financeiro.controller;

import financeiro.example.financeiro.dto.RequestUserDto;
import financeiro.example.financeiro.dto.ResponseUserDto;
import financeiro.example.financeiro.entity.Usuario;
import financeiro.example.financeiro.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(value ="/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> create (@RequestBody RequestUserDto dto) {
        Usuario usuario = usuarioService.create(dto);
        return ResponseEntity.ok().body(usuario);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Usuario> findOne (@PathVariable Long id){
        Usuario usuario = usuarioService.findOne(id);
        return ResponseEntity.ok().body(usuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll () {
        List<Usuario> usuario = usuarioService.findAll();
        return ResponseEntity.ok().body(usuario);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseUserDto> update (
            @PathVariable Long id,
            @RequestBody RequestUserDto dto)
            throws Exception {
        ResponseUserDto user = usuarioService.update(id, dto);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id) throws Exception {
         usuarioService.delete(id);
         return ResponseEntity.noContent().build();
    }




}
