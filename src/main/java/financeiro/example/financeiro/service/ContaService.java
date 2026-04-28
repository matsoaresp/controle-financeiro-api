package financeiro.example.financeiro.service;

import financeiro.example.financeiro.dto.RequestContaDto;
import financeiro.example.financeiro.entity.Conta;
import financeiro.example.financeiro.entity.ContaCorrente;
import financeiro.example.financeiro.entity.ContaPoupanca;
import financeiro.example.financeiro.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;


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

    public List<Conta> findAll (){
        return contaRepository.findAll();
    }

    public Conta findOne (Long id) {
        return contaRepository.findById(id).orElseThrow(() -> new RuntimeException("Conta não encontrada"));
    }

    public void delete (Long id) throws Exception {
        Conta conta = findOne(id);
        contaRepository.delete(conta);
    }
}
