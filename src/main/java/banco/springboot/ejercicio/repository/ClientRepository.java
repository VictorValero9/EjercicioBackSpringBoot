package banco.springboot.ejercicio.repository;

import banco.springboot.ejercicio.model.BankAccount;
import banco.springboot.ejercicio.model.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Repository
public class ClientRepository {
    public static final Map<Long, Client> clients = new HashMap<>();
    private static long clientIdCounter = 1;

    public Client save(Client client){
        if (client.getId()==null){
            client.setId(clientIdCounter++);
        }
        clients.put(client.getId(),client);
        return client;
    }

    public Client findById(Long id){
        return clients.get(id);
    }

    public List<Client> findAll(){
        return new ArrayList<>(clients.values());
    }

    public List<BankAccount> findByClient_ID(Long clientID) {
        Client client = clients.get(clientID);

        if (client != null) {
            return client.getAccountList();
        } else {
            throw new RuntimeException("Client not found with ID: " + clientID);
        }
    }

}
