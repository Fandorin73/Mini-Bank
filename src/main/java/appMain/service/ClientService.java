package appMain.service;

import appMain.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

   public void getClientService() throws SQLException {
       clientRepository.getClient("Иванов Иван Иванович",4500,163166);
   }

}
