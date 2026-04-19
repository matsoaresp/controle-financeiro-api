package financeiro.example.financeiro.dto;

import jakarta.validation.constraints.NotBlank;

public class RequestContaDto {
    @NotBlank
    private String numero;

    @NotBlank
    private String banco;

    @NotBlank
    private String agencia;

    @NotBlank
    private String tipoConta;

    public @NotBlank String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(@NotBlank String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public @NotBlank String getAgencia() {
        return agencia;
    }

    public void setAgencia(@NotBlank String agencia) {
        this.agencia = agencia;
    }

    public @NotBlank String getBanco() {
        return banco;
    }

    public void setBanco(@NotBlank String banco) {
        this.banco = banco;
    }

    public @NotBlank String getNumero() {
        return numero;
    }

    public void setNumero(@NotBlank String numero) {
        this.numero = numero;
    }


}
