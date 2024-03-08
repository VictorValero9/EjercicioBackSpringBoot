package banco.springboot.ejercicio.model;

import java.util.List;

public class BankAccount {

    private Long id;
    private String iban;
    private double currency;
    private List<Operation> operations;
    private Client client;

    public BankAccount(long id, String iban, double currency, List<Operation> operations, Client client) {
        this.id = id;
        this.iban = iban;
        this.currency = currency;
        this.operations = operations;
        this.client = client;
    }

    public BankAccount() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getCurrency() {
        return currency;
    }

    public void setCurrency(double currency) {
        this.currency = currency;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    public Client getClient(){return client;}
}
