package financeiro.example.financeiro.service;

import financeiro.example.financeiro.dto.request.RequestContaDto;
import financeiro.example.financeiro.entity.Conta;
import financeiro.example.financeiro.entity.ContaCorrente;
import financeiro.example.financeiro.entity.ContaPoupanca;
import financeiro.example.financeiro.entity.Usuario;
import financeiro.example.financeiro.enums.ContaType;
import financeiro.example.financeiro.exception.Conta.AccountDataIncorrect;
import financeiro.example.financeiro.exception.Conta.AccountNotFound;
import financeiro.example.financeiro.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private UsuarioService usuarioService;

    public Conta create (RequestContaDto contaDto){

        Usuario usuario = usuarioService.findOne(contaDto.getUsuario().getId());
        Conta conta;
        if (contaDto.getTipoConta() == ContaType.CORRENTE){
            conta = new ContaCorrente();
        }else if (contaDto.getTipoConta() == ContaType.POUPANCA){
            conta = new ContaPoupanca();
        } else {
            throw new AccountDataIncorrect();
        }
        conta.setNumero(contaDto.getNumero());
        conta.setBanco(contaDto.getBanco());
        conta.setAgencia(contaDto.getAgencia());
        conta.setUsuario(usuario);
        conta.setTipoConta(contaDto.getTipoConta());

        return contaRepository.save(conta);
    }

    public List<Conta> findAll (){
        return contaRepository.findAll();
    }

    public Conta findOne (Long id) {
        return contaRepository.findById(id).orElseThrow(AccountNotFound::new);
    }
    public void delete (Long id) throws Exception {
        Conta conta = findOne(id);
        contaRepository.delete(conta);
    }
}
