package appMain.repositories;

import appMain.entitis.Client;
import appMain.repositories.ConnectionPostrgres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ClientRepository {


    ConnectionPostrgres connectionPostrgres = new ConnectionPostrgres();
    Client client = new Client();

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
        return client;

    }

}
