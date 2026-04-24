package financeiro.example.financeiro.controller;
import financeiro.example.financeiro.dto.RequestContaDto;
import financeiro.example.financeiro.entity.Conta;
import financeiro.example.financeiro.service.ContaService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @PostMapping
    public ResponseEntity<Conta> create (@RequestBody RequestContaDto dto) throws Exception {
        Conta conta = contaService.create(dto);
        return ResponseEntity.status(201).body(conta);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Conta> findOne (
            @PathVariable Long id){
        Conta conta = contaService.findOne(id);
        return ResponseEntity.ok().body(conta);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<List<Conta>> findAll (){
        List<Conta> conta = contaService.findAll();
        return ResponseEntity.ok().body(conta);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id) throws  Exception{
        contaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
