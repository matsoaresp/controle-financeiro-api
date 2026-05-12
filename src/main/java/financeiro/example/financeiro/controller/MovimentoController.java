package financeiro.example.financeiro.controller;

import financeiro.example.financeiro.dto.request.RequestTransacaoDto;
import financeiro.example.financeiro.entity.Movimento;
import financeiro.example.financeiro.service.MovimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movimentos")
public class MovimentoController {

    @Autowired
    private MovimentoService service;

    @PostMapping("transacao")
    public ResponseEntity<Movimento> transaction (@RequestBody RequestTransacaoDto dto){
        Movimento movimento = service.transfer(dto);
        return ResponseEntity.status(201).body(movimento);
    }

    @PostMapping("/deposito")
    public ResponseEntity<Movimento> deposit (@RequestBody RequestTransacaoDto dto){
        Movimento movimento = service.deposit(dto);
        return ResponseEntity.status(201).body(movimento);
    }

    @PostMapping("/saque")
    public ResponseEntity<Movimento> withdraw (@RequestBody RequestTransacaoDto dto){
        Movimento withdraw = service.withdraw(dto);
        return ResponseEntity.status(201).body(withdraw);
    }

}
