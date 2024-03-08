package banco.springboot.ejercicio.service;

import banco.springboot.ejercicio.repository.OperationRepository;
import org.springframework.stereotype.Service;

@Service
public class OperationService {
    private final OperationRepository operationRepository;

    public OperationService(OperationRepository operationRepository){
        this.operationRepository = operationRepository;
    }
}
