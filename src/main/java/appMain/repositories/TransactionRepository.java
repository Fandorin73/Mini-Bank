package appMain.repositories;

import appMain.entitis.Transactions;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

/**
 * Класс Репозиторий "Репозиторий Транзакций".
 *
 * @author Пьянзин Андрей
 * @version 1.1
 * @since 12.03.2021
 */
@Repository
public class TransactionRepository {
    ConnectionPostrgres connectionPostrgres = new ConnectionPostrgres();
    Transactions transactions = new Transactions();

    /**
     * репозиторий сохраняет транзакцию в базу
     */
    public void saveTransactions(long Bill_Id, double Sum_Transaction, String Data_Transaction) throws SQLException {
        connectionPostrgres.connect();
        connectionPostrgres.statement.executeUpdate("INSERT INTO Transactions (Bill_Id, Sum_Transaction, Data_Transaction) VALUES (" + Bill_Id + "," + Sum_Transaction + ",'" + Data_Transaction + "')");
        connectionPostrgres.disconnect();

    }
}
