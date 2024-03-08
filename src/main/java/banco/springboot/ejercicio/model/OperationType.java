package banco.springboot.ejercicio.model;

public enum OperationType {
    INCOME("Income"),
    WITHDRAWAL("Withdrawal"),
    TRANSFER("Transfer");

    private final String description;
    OperationType(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
