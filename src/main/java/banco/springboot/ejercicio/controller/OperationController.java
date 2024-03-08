package banco.springboot.ejercicio.controller;

import banco.springboot.ejercicio.repository.OperationRepository;
import banco.springboot.ejercicio.service.OperationService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperationController {
    private final OperationService operationService;

    public OperationController(OperationService operationService){
        this.operationService = operationService;
    }
}
