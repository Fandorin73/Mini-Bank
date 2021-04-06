package appMain.repositories;

import appMain.entitis.Bills;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Класс Репозиторий "Репозиторий Счетов".
 *
 * @author Пьянзин Андрей
 * @version 1.1
 * @since 12.03.2021
 */
@Repository
public class BillRepository {
    ConnectionPostrgres connectionPostrgres = new ConnectionPostrgres();
    Bills bills = new Bills();

    /**
     * репозиторий получает данные счета
     */
    public Bills getBills(long NumId, long NumBill) throws SQLException {
        connectionPostrgres.connect();
        ResultSet resultSet = connectionPostrgres.statement.executeQuery("SELECT * FROM Bills  WHERE Client_id = " + NumId + " and Num_bill = " + NumBill);
        while (resultSet.next()) {
            bills.setClient_Id(resultSet.getInt(1));
            bills.setNum_Bill(resultSet.getInt(2));
            bills.setSum_Bills(resultSet.getInt(3));
            bills.setData_Begin(resultSet.getString(4));
            bills.setData_End(resultSet.getString(5));
        }
        connectionPostrgres.disconnect();
        return bills;
    }

    /**
     * репозиторий вносит данные нового счета в базу
     */
    public void addBills(int ClientId, double Sum, String DataBegin) throws SQLException {
        connectionPostrgres.connect();
        connectionPostrgres.statement.executeUpdate("INSERT INTO Bills (Client_Id, Sum_Bills, Data_Begin) VALUES (" + ClientId + "," + Sum + ",'" + DataBegin + "')");
        connectionPostrgres.disconnect();
    }

    /**
     * репозиторий изменяет сумму на счету после снятия или внесения средств
     */
    public void changeSumBills(long Num_Bill, double Sum) throws SQLException {
        connectionPostrgres.connect();
        connectionPostrgres.statement.executeUpdate(" UPDATE  Bills SET Sum_Bills= Sum_Bills + " + Sum + " WHERE Num_Bill = " + Num_Bill);
        connectionPostrgres.disconnect();
    }

}
