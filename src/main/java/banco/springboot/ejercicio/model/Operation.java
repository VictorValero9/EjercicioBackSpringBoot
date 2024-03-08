package banco.springboot.ejercicio.model;

public class Operation {
    private Long id;
    private double amount;
    private OperationType type;
    private String description;
    private String date;

    public Operation(long id, double amount, OperationType type, String description, String date) {
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.description = description;
        this.date = date;
    }

    public Operation() {

    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public OperationType getType() {
        return type;
    }

    public void setType(OperationType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
