package banco.springboot.ejercicio.controller;

import banco.springboot.ejercicio.model.BankAccount;
import banco.springboot.ejercicio.model.Client;
import banco.springboot.ejercicio.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @GetMapping("/{clientid}/bank-accounts")
    public ResponseEntity<List<BankAccount>> getBankAccountByClientID(@PathVariable Long clientID){
        List<BankAccount> bankAccounts = clientService.getBankAccountsByClientID(clientID);
        return new ResponseEntity<>(bankAccounts, HttpStatus.OK);
    }
}
