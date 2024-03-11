package banco.springboot.ejercicio.service;

import banco.springboot.ejercicio.model.BankAccount;
import banco.springboot.ejercicio.model.Client;
import banco.springboot.ejercicio.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long clientId) {
        return clientRepository.findById(clientId);
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }
    public List<BankAccount> getBankAccountsByClientID(Long clientID) {
        // En el método findByClient_ID del repositorio
        System.out.println("Calling findByClient_ID with clientID: " + clientID);
        List<BankAccount> bankAccounts = clientRepository.findByClient_ID(clientID);
        System.out.println("Found bank accounts: " + bankAccounts);

        return clientRepository.findByClient_ID(clientID);

    }
}
