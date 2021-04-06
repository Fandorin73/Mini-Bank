package appMain.repositories;

import appMain.entitis.Client;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Класс Репозиторий "Репозиторий Клиентов".
 *
 * @author Пьянзин Андрей
 * @version 1.1
 * @since 12.03.2021
 */
@Repository
public class ClientRepository {

    ConnectionPostrgres connectionPostrgres = new ConnectionPostrgres();
    Client client = new Client();

    /**
     * репозиторий получает данные клиента
     */
    public Client getClient(String name, int SerPas, int NumPas) throws SQLException {
        connectionPostrgres.connect();
        ResultSet resultSet = connectionPostrgres.statement.executeQuery("SELECT * FROM Client  WHERE NAME = " + "'" + name + "'" + " and Pasport_Serial = " + SerPas + " and Pasport_Number = " + NumPas);
        while (resultSet.next()) {
            client.setId(resultSet.getInt(1));
            client.setName(resultSet.getString(2));
            client.setPasport_Serial(resultSet.getInt(3));
            client.setPasport_Number(resultSet.getInt(4));
            client.setTelephone_Number(resultSet.getString(5));
            client.setAdress(resultSet.getString(6));
        }
        connectionPostrgres.disconnect();
        return client;
    }

    /**
     * репозиторий добавляет нового клиента
     */
    public Client addNewClient(String name, int SerPas, int NumPas, String TelNum, String Adress) throws SQLException {
        connectionPostrgres.connect();
        connectionPostrgres.statement.executeUpdate("INSERT INTO Client (Name, Pasport_Serial, Pasport_Number, Telephone_Number, Adress) VALUES ('" + name + "'," + SerPas + "," + NumPas + ",'" + TelNum + "','" + Adress + "')");
        connectionPostrgres.disconnect();
        return client;
    }

    /**
     * репозиторий возвращает ID клиента
     */
    public int getIDClient(String name, int SerPas, int NumPas) throws SQLException {
        Client client = getClient(name, SerPas, NumPas);
        return client.getId();
    }
}
