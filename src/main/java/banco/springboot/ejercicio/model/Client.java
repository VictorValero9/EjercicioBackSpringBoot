package banco.springboot.ejercicio.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private Long id;
    private String name;
    @JsonIgnore
    private List<BankAccount> accountList = new ArrayList<>();

    public Client(long id, String name, List<BankAccount> accountList) {
        this.id = id;
        this.name = name;
        this.accountList = accountList;
    }

    public Client() {

    }
    public void addBankAccount(BankAccount bankAccount) {
        accountList.add(bankAccount);
        bankAccount.setClient(this);
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
