package banco.springboot.ejercicio.controller;

import banco.springboot.ejercicio.model.BankAccount;
import banco.springboot.ejercicio.model.BankAccountRequest;
import banco.springboot.ejercicio.model.Client;
import banco.springboot.ejercicio.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @GetMapping("/{clientID}/bank-accounts")
    public ResponseEntity<List<BankAccount>> getBankAccountByClientID(@PathVariable Long clientID){
        List<BankAccount> bankAccounts = clientService.getBankAccountsByClientID(clientID);
        return new ResponseEntity<>(bankAccounts, HttpStatus.OK);
    }

    @PostMapping("/{clientID}/bank-accounts")
    public ResponseEntity<BankAccount> createBankAccountForClient(
            @PathVariable Long clientID,
            @RequestBody BankAccountRequest bankAccountRequest) {

        Client client = clientService.getClientById(clientID);

        BankAccount newBankAccount = new BankAccount();
        newBankAccount.setIban(bankAccountRequest.getIban());
        newBankAccount.setCurrency(0.0);

        client.addBankAccount(newBankAccount);

        clientService.saveClient(client);
        return new ResponseEntity<>(newBankAccount, HttpStatus.CREATED);
    }
}
