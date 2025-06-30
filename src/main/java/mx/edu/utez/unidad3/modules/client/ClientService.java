package mx.edu.utez.unidad3.modules.client;
import mx.edu.utez.unidad3.utils.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    /*
     * private final ClientRepository clientRepository;
     *
     * public ClientService(ClientRepository clientRepository){
     * this.clientRepository = clientRepository;
     * }
     * */

    @Transactional(readOnly = true)
    public APIResponse findAll(){
        List<Client> list = clientRepository.findAll();
        return new APIResponse("Operacion exitosa", list, false, HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public APIResponse findById(Long id){
       try{
           Client found = clientRepository.findById(id).orElse(null)
           if (found == null) {
               return new APIResponse("No se encontro el registro", null, false, HttpStatus.NOT_FOUND);
           }
           return new APIResponse("Operacion exitosa", null, false, HttpStatus.OK);
       }catch (Exception ex){
           ex.printStackTrace();
           return new APIResponse("No se puedo consultar el registro", null, false, HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    @Transactional(readOnly = true)
    public APIResponse save(Client payload){
        try {
            clientRepository.save(payload);
            return new APIResponse("Operacion exitosa", null, false, HttpStatus.CREATED);

        }catch (Exception ex){
            ex.printStackTrace();
            return new APIResponse("no se puedo consultar al cliente ",true, HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @Transactional(readOnly = true)
    public APIResponse update(){
        return null;
    }

    @Transactional(readOnly = true)
    public APIResponse remove(){
        return null;
    }
}