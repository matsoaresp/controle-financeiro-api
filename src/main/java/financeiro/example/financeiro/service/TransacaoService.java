package financeiro.example.financeiro.service;

import financeiro.example.financeiro.dto.request.RequestTransacaoDto;
import financeiro.example.financeiro.entity.Conta;
import financeiro.example.financeiro.entity.Transacao;
import financeiro.example.financeiro.entity.Usuario;
import financeiro.example.financeiro.enums.TransactionType;
import financeiro.example.financeiro.exception.Conta.AccountNotFound;
import financeiro.example.financeiro.exception.Usuario.UserFullException;
import financeiro.example.financeiro.exception.Usuario.UserNotFoundException;
import financeiro.example.financeiro.repository.ContaRepository;
import financeiro.example.financeiro.repository.TransacaoRepository;
import financeiro.example.financeiro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepo;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ContaService contaService;


    public Transacao transfer (RequestTransacaoDto dto){

        Usuario usuario = usuarioService.findOne(dto.getUsuario().getId());
        Conta conta = contaService.findOne(dto.getContas().getId());
        Transacao transacao = new Transacao();
        transacao.setValor(dto.getValor());
        transacao.setType(TransactionType.TRANSFER);
        transacao.setUsuario(usuario);
        transacao.setTimestamp(LocalDateTime.now());
        transacao.setContas(Collections.singletonList(conta));
        return transacaoRepo.save(transacao);
    }

    public  Transacao deposit(RequestTransacaoDto dto){

        Usuario usuario = usuarioService.findOne(dto.getUsuario().getId());
        Conta conta = contaService.findOne(dto.getContas().getId());

        Transacao transacao = new Transacao();
        transacao.setValor(dto.getValor());
        transacao.setType(TransactionType.DEPOSIT);
        transacao.setUsuario(usuario);
        transacao.setTimestamp(LocalDateTime.now());
        transacao.setContas(Collections.singletonList(conta));

        return transacaoRepo.save(transacao);
    }

}
