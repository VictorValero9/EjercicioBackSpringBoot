package banco.springboot.ejercicio.repository;

import banco.springboot.ejercicio.model.BankAccount;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BankAccountRepository {
    public static final Map<Long, BankAccount> bankAccountMap = new HashMap<>();
    private static long bankAccountIdCounter = 1;

    public BankAccount save(BankAccount bankAccount){
        if (bankAccount.getId()==null){
            bankAccount.setId(bankAccountIdCounter++);
        }
        bankAccountMap.put(bankAccount.getId(),bankAccount);
        return bankAccount;
    }

    public BankAccount findById(Long id){
        return bankAccountMap.get(id);
    }

    public List<BankAccount> findAll(){
        return new ArrayList<>(bankAccountMap.values());
    }
}
