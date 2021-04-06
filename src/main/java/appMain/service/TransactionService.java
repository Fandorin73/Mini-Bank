package appMain.service;

import appMain.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service

/**
 * Класс Сервис "Транзакции по счету клиента".
 *
 * @author Пьянзин Андрей
 * @version 1.1
 * @since 12.03.2021
 */
public class TransactionService {
    TransactionRepository transactionRepository = new TransactionRepository();

    /**
     * метод сохраняет транзакцию по счету клиента
     */
    public void saveTransactionsService(long Bill_Id, double Sum_Transaction, String Data_Transaction) throws SQLException {
        transactionRepository.saveTransactions(Bill_Id, Sum_Transaction, Data_Transaction);
    }

}
