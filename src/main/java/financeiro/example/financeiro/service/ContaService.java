package financeiro.example.financeiro.service;

import financeiro.example.financeiro.dto.RequestContaDto;
import financeiro.example.financeiro.entity.Conta;
import financeiro.example.financeiro.entity.ContaCorrente;
import financeiro.example.financeiro.entity.ContaPoupanca;
import financeiro.example.financeiro.repository.ContaCorrenteRepository;
import financeiro.example.financeiro.repository.ContaPoupancaRepository;
import financeiro.example.financeiro.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;
    @Autowired
    private ContaPoupancaRepository poupancaRepository;
    @Autowired
    private ContaCorrenteRepository correnteRepository;


    public Conta create (RequestContaDto contaDto) throws  Exception{

        Conta conta;

        if (contaDto.getTipoConta().equalsIgnoreCase("CORRENTE")){
            conta = new ContaCorrente();
        }else if (contaDto.getTipoConta().equalsIgnoreCase("POUPANCA")){
            conta = new ContaPoupanca();
        } else {
            throw new Exception("Dados informados incorretamente");
        }

        conta.setNumero(contaDto.getNumero());
        conta.setBanco(contaDto.getBanco());
        conta.setAgencia(contaDto.getAgencia());

        return contaRepository.save(conta);
    }
}
