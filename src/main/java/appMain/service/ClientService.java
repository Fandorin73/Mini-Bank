package appMain.service;

import appMain.entitis.Client;
import appMain.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service

/**
 * Класс Сервис "Операции клиента".
 *
 * @author Пьянзин Андрей
 * @version 1.1
 * @since 12.03.2021
 */
public class ClientService {

    ClientRepository clientRepository = new ClientRepository();

    /**
     * метод возвращает текущего Клиента из репозитория
     */
    public Client getClientService(Client client) throws SQLException {
        return clientRepository.getClient(client.getName(), client.getPasport_Serial(), client.getPasport_Number());
    }

    /**
     * метод создает нового Клиента
     */
    public Client addClientService(Client client) throws SQLException {
        return clientRepository.addNewClient(client.getName(), client.getPasport_Serial(), client.getPasport_Number(), client.getTelephone_Number(), client.getAdress());
    }

    /**
     * метод получает ID текущего Клиента
     */
    public int getIdClientService(Client client) throws SQLException {

        return clientRepository.getIDClient(client.getName(), client.getPasport_Serial(), client.getPasport_Number());
    }
}

