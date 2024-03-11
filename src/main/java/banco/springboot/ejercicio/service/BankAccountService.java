package banco.springboot.ejercicio.service;

import banco.springboot.ejercicio.model.BankAccount;
import banco.springboot.ejercicio.model.Operation;
import banco.springboot.ejercicio.model.OperationType;
import banco.springboot.ejercicio.repository.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BankAccountService {
    private final BankAccountRepository bankAccountRepository;

    public BankAccountService(BankAccountRepository bankAccountRepository){
        this.bankAccountRepository = bankAccountRepository;
    }

    public BankAccount saveBankAccount(BankAccount bankAccount) {
        bankAccountRepository.save(bankAccount);
        return bankAccount;
    }

    public List<BankAccount> getAllBankAccounts() {
        return bankAccountRepository.findAll();
    }

    public void deposit(Long bankAccountID, double amount){
        BankAccount bankAccount = getBankAccountById(bankAccountID);
        bankAccount.setCurrency(bankAccount.getCurrency()+amount);

        Operation depositOperation = createOperation(amount, OperationType.INCOME, "Deposit");
        bankAccount.getOperations().add(depositOperation);

        saveBankAccount(bankAccount);
    }

    private Operation createOperation(double amount, OperationType operationType, String description) {
        Operation operation = new Operation();
        operation.setAmount(amount);
        operation.setType(operationType);
        operation.setDescription(description);
        operation.setDate(String.valueOf(LocalDateTime.now()));

        return operation;
    }

    private BankAccount getBankAccountById(Long bankAccountID) {
        return bankAccountRepository.findById(bankAccountID);
    }

    public void withdraw(Long bankAccountId, double amount) {
        BankAccount bankAccount = getBankAccountById(bankAccountId);

        if (bankAccount.getCurrency() < amount) {
            throw new RuntimeException("Insufficient funds");
        }

        bankAccount.setCurrency(bankAccount.getCurrency() - amount);

        Operation withdrawalOperation = createOperation(amount, OperationType.WITHDRAWAL, "Withdrawal");
        bankAccount.getOperations().add(withdrawalOperation);

        saveBankAccount(bankAccount);
    }
}
