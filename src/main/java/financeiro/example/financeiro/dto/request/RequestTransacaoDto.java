package financeiro.example.financeiro.dto.request;

import financeiro.example.financeiro.entity.Conta;
import financeiro.example.financeiro.entity.Usuario;
import financeiro.example.financeiro.enums.TransactionType;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestTransacaoDto {

    @NotBlank
    private double valor;

    @NotBlank
    private TransactionType type;

    @NotBlank
    private Usuario usuario;

    @NotBlank
    private Conta contas;



}
