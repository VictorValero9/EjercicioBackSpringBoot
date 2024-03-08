package banco.springboot.ejercicio.model;


import java.util.List;

public class Client {
    private Long id;
    private String name;
    private List<BankAccount> accountList;

    public Client(long id, String name, List<BankAccount> accountList) {
        this.id = id;
        this.name = name;
        this.accountList = accountList;
    }

    public Client() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BankAccount> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<BankAccount> accountList) {
        this.accountList = accountList;
    }
}
