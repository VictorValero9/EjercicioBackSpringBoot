package banco.springboot.ejercicio;

import banco.springboot.ejercicio.model.BankAccount;
import banco.springboot.ejercicio.model.Client;
import banco.springboot.ejercicio.model.Operation;
import banco.springboot.ejercicio.model.OperationType;
import banco.springboot.ejercicio.service.BankAccountService;
import banco.springboot.ejercicio.service.ClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    private final BankAccountService bankAccountService;
    private final ClientService clientService;

    public DataLoader(BankAccountService bankAccountService, ClientService clientService){

        this.bankAccountService = bankAccountService;
        this.clientService = clientService;

    }

    @Override
    public void run(String... args){
        Client client = new Client();
        client.setName("Juan Carlos");
        client.setId(1L);

        BankAccount bankAccount = new BankAccount();
        bankAccount.setIban("ES1234567890123456789012");

        // Añade la cuenta bancaria al cliente
        client.addBankAccount(bankAccount);

        // Guarda el cliente y la cuenta bancaria
        clientService.saveClient(client);
        bankAccountService.saveBankAccount(bankAccount);

        // Después de crear el cliente y la cuenta bancaria en el método run de DataLoader
        System.out.println("Client after creation: " + clientService.getClientById(1L));
        System.out.println("Bank accounts after creation: " + clientService.getClientById(1L).getAccountList());



        List<Operation> operation = new ArrayList<>();

        Operation deposit = new Operation();
        deposit.setAmount(100.0);
        deposit.setType(OperationType.INCOME);
        deposit.setDescription("Operation 1");
        operation.add(deposit);

        Operation withdrawal = new Operation();
        withdrawal.setAmount(50);
        withdrawal.setType(OperationType.WITHDRAWAL);
        withdrawal.setDescription("Operation 2");
        operation.add(withdrawal);

        bankAccount.setOperations(operation);

        bankAccountService.saveBankAccount(bankAccount);

    }
}
