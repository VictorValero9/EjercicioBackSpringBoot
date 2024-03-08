package banco.springboot.ejercicio.controller;

import banco.springboot.ejercicio.model.BankAccount;
import banco.springboot.ejercicio.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bank-accounts")
public class BankAccountController {
    private final BankAccountService bankAccountService;

    @Autowired
    public BankAccountController(BankAccountService bankAccountService){
        this.bankAccountService = bankAccountService;
    }

    @PostMapping
    public ResponseEntity<BankAccount> createBankAccount(@RequestBody BankAccount bankAccount){
        BankAccount savedAccount = bankAccountService.saveBankAccount(bankAccount);
        return new ResponseEntity<>(savedAccount, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BankAccount>> getAllAccounts(){
        List<BankAccount> bankAccountList = bankAccountService.getAllBankAccounts();
        return new ResponseEntity<>(bankAccountList, HttpStatus.OK);
    }
}
