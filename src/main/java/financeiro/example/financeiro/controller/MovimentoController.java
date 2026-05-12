package financeiro.example.financeiro.controller;

import financeiro.example.financeiro.dto.request.RequestTransacaoDto;
import financeiro.example.financeiro.entity.Movimento;
import financeiro.example.financeiro.service.MovimentoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentos")
public class MovimentoController {

    @Autowired
    private MovimentoService service;

    @PostMapping("/transacao")
    public ResponseEntity<Movimento> transaction (@RequestBody RequestTransacaoDto dto){
        Movimento transaction = service.transfer(dto);
        return ResponseEntity.status(201).body(transaction);
    }

    @PostMapping("/deposito")
    public ResponseEntity<Movimento> deposit (@RequestBody RequestTransacaoDto dto){
        Movimento deposit = service.deposit(dto);
        return ResponseEntity.status(201).body(deposit);
    }

    @PostMapping("/saque")
    public ResponseEntity<Movimento> withdraw (@RequestBody RequestTransacaoDto dto){
        Movimento withdraw = service.withdraw(dto);
        return ResponseEntity.status(201).body(withdraw);
    }

    @GetMapping
    public ResponseEntity<List<Movimento>> findAll (){
        List<Movimento> findAll = service.findAll();
        return ResponseEntity.ok().body(findAll);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Movimento> findOne (@PathVariable Long id){
        Movimento findOne = service.findOne(id);
        return ResponseEntity.ok().body(findOne);
    }

}
