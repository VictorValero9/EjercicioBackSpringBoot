package banco.springboot.ejercicio.service;

import banco.springboot.ejercicio.model.BankAccount;
import banco.springboot.ejercicio.repository.BankAccountRepository;
import org.springframework.stereotype.Service;

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
}
