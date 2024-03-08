package banco.springboot.ejercicio.repository;

import banco.springboot.ejercicio.model.Operation;
import banco.springboot.ejercicio.model.OperationType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OperationRepository {
    private static final Map<Long, Operation> operationMap = new HashMap<>();
    private static long operationIDCounter = 1;

    public Operation save(Operation operation){
        if (operation.getId()==null){
            operation.setId(operationIDCounter);
        }
        operationMap.put(operation.getId(), operation);
        return operation;
    }

    public Operation findByID(Long id){
        return operationMap.get(id);
    }

    public List<Operation> findAll(){
        return new ArrayList<>(operationMap.values());
    }
}
