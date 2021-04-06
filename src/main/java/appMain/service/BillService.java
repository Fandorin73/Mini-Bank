package appMain.service;

import appMain.entitis.Bills;
import appMain.repositories.BillRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * Класс Сервис "Операции по счету клиента".
 *
 * @author Пьянзин Андрей
 * @version 1.1
 * @since 12.03.2021
 */
@Service
public class BillService {
    BillRepository billRepository = new BillRepository();

    /**
     * метод открывает cчет клиента
     */
    public Bills getBillService(long Id, long Num_Bill) throws SQLException {
        return billRepository.getBills(Id, Num_Bill);
    }

    /**
     * метод Создает cчет клиента
     */
    public void addBillService(int ClientId, double Sum, String DataBegin) throws SQLException {
        billRepository.addBills(ClientId, Sum, DataBegin);
    }

    /**
     * метод снимает, либо вносит денежные средства на счет клиента
     */
    public void changeSum(long Num_Bill, double Sum) throws SQLException {
        billRepository.changeSumBills(Num_Bill, Sum);
    }
}
