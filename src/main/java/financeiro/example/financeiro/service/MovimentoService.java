package financeiro.example.financeiro.service;

import financeiro.example.financeiro.dto.request.RequestTransacaoDto;
import financeiro.example.financeiro.entity.Conta;
import financeiro.example.financeiro.entity.Movimento;
import financeiro.example.financeiro.entity.Usuario;
import financeiro.example.financeiro.enums.TransactionType;
import financeiro.example.financeiro.exception.Conta.AccountSmallerValues;
import financeiro.example.financeiro.repository.ContaRepository;
import financeiro.example.financeiro.repository.MovimentoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;

@Service
public class MovimentoService {

    private final MovimentoRepository movimentoRepo;
    private final UsuarioService usuarioService;
    private final ContaService contaService;
    private final ContaRepository contaRepo;

    public MovimentoService(MovimentoRepository movimentoRepo, UsuarioService usuarioService, ContaService contaService, ContaRepository contaRepo) {
        this.movimentoRepo = movimentoRepo;
        this.usuarioService = usuarioService;
        this.contaService = contaService;
        this.contaRepo = contaRepo;
    }


    private Movimento criarMovimento (
            RequestTransacaoDto dto,
            TransactionType type){

        Usuario usuario = usuarioService.findOne(dto.getUsuario().getId());
        Conta conta = contaService.findOne(dto.getContas().getId());
        Movimento movimento = new Movimento();

        movimento.setValor(dto.getValor());
        movimento.setType(type);
        movimento.setUsuario(usuario);
        movimento.setTimestamp(LocalDateTime.now());
        movimento.setContas(Collections.singletonList(conta));
        return movimentoRepo.save(movimento);
    }

    public Movimento transfer (RequestTransacaoDto dto){
        Conta conta = contaService.findOne(dto.getContas().getId());
        if (conta.getSaldo() < dto.getValor()){
            throw new AccountSmallerValues();
        }
            conta.setSaldo(conta.getSaldo() - dto.getValor());
            contaRepo.save(conta);

        return movimentoRepo.save(criarMovimento(dto,TransactionType.TRANSFER));
    }


    public Movimento deposit(RequestTransacaoDto dto){
        Conta conta = contaService.findOne(dto.getContas().getId());
        conta.setSaldo(conta.getSaldo() - dto.getValor());
        return movimentoRepo.save(criarMovimento(dto,TransactionType.DEPOSIT));
    }

    public Movimento withdraw(RequestTransacaoDto dto){
        Conta conta = contaService.findOne(dto.getContas().getId());
        if (conta.getSaldo() < dto.getValor()){
            throw new AccountSmallerValues("ERRO: Saldo é menor que o valor solicitado para sacar");
        }
        conta.setSaldo(conta.getSaldo() - dto.getValor());
        contaRepo.save(conta);

        return (criarMovimento(dto,TransactionType.WITHDRAW));
    }

}
