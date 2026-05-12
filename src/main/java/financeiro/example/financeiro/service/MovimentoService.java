package financeiro.example.financeiro.service;

import financeiro.example.financeiro.dto.request.RequestTransacaoDto;
import financeiro.example.financeiro.entity.Conta;
import financeiro.example.financeiro.entity.Movimento;
import financeiro.example.financeiro.entity.Usuario;
import financeiro.example.financeiro.enums.TransactionType;
import financeiro.example.financeiro.repository.MovimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;

@Service
public class MovimentoService {

    @Autowired
    private MovimentoRepository movimentoRepo;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ContaService contaService;


    public Movimento transfer (RequestTransacaoDto dto){

        Usuario usuario = usuarioService.findOne(dto.getUsuario().getId());
        Conta conta = contaService.findOne(dto.getContas().getId());
        Movimento movimento = new Movimento();
        movimento.setValor(dto.getValor());
        movimento.setType(TransactionType.TRANSFER);
        movimento.setUsuario(usuario);
        conta.setSaldo(dto.getValor() - conta.getSaldo());
        movimento.setTimestamp(LocalDateTime.now());
        movimento.setContas(Collections.singletonList(conta));
        return movimentoRepo.save(movimento);
    }

    public Movimento deposit(RequestTransacaoDto dto){

        Usuario usuario = usuarioService.findOne(dto.getUsuario().getId());
        Conta conta = contaService.findOne(dto.getContas().getId());

        Movimento deposit = new Movimento();
        deposit.setValor(dto.getValor());
        deposit.setType(TransactionType.DEPOSIT);
        deposit.setUsuario(usuario);
        conta.setSaldo(dto.getValor() + conta.getSaldo());
        deposit.setTimestamp(LocalDateTime.now());
        deposit.setContas(Collections.singletonList(conta));

        return movimentoRepo.save(deposit);
    }

    public Movimento witdraw (RequestTransacaoDto dto){

        Usuario usuario = usuarioService.findOne(dto.getUsuario().getId());
        Conta conta = contaService.findOne(dto.getContas().getId());

        Movimento witdraw = new Movimento();
        witdraw.setValor(dto.getValor());
        witdraw.setType(TransactionType.DEPOSIT);
        witdraw.setUsuario(usuario);
        conta.setSaldo(dto.getValor() - conta.getSaldo());
        witdraw.setTimestamp(LocalDateTime.now());
        witdraw.setContas(Collections.singletonList(conta));

        return movimentoRepo.save(witdraw);
    }

}
