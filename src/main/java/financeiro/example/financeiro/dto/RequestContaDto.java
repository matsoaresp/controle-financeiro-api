package financeiro.example.financeiro.dto;

import financeiro.example.financeiro.entity.Usuario;
import financeiro.example.financeiro.enums.ContaType;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestContaDto {
    @NotBlank
    private String numero;

    @NotBlank
    private String banco;

    @NotBlank
    private String agencia;

    @NotBlank
    private ContaType tipoConta;

    @NotBlank
    private Usuario usuario;
}
