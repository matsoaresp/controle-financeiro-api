package financeiro.example.financeiro.enums;

public enum ContaType {
    CORRENTE("CORRENTE"),
    POUPANCA("POUPANCA");

    private String type;

    ContaType (String type){
        this.type = type;
    }
}
