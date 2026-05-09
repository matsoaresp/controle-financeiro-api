package financeiro.example.financeiro.enums;

public enum TransactionType {
    DEPOSIT("DEPOSITO"),
    WITHDRAW("SACAR"),
    TRANSFER("TRANSFERENCIA");

    private String type;

    TransactionType(String type) {this.type = type;}
}
