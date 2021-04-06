package appMain.controllers;

import appMain.entitis.Transactions;
import appMain.entitis.Bills;
import appMain.entitis.Client;
import appMain.service.BillService;
import appMain.service.ClientService;
import appMain.service.TransactionService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

/**
 * Контролер для управления
 */
@Controller
public class MainController {

    ClientService clientService = new ClientService();
    BillService billService = new BillService();
    TransactionService transactionService = new TransactionService();

    /**
     * Окно вывода главной страницы
     *
     * @return главная страница
     */
    @GetMapping
    public String main() {
        return "main";
    }

    /**
     * Окно ввода нового клиента
     *
     * @return вводиться новый клиент
     */
    @GetMapping("/newClient")
    public String newClient(Model model, Client client) throws SQLException {
        model.addAttribute("client", client);
        return "newClient";
    }

    /**
     * Окно открытия данных клиента
     *
     * @return вводяться данные клиента для открытия
     */
    @GetMapping("/openClient")
    public String openClient(Model model, Client client) throws SQLException {
        model.addAttribute("client", client);
        return "openClient";
    }

    /**
     * Окно открытия счета клиента
     *
     * @return вводяться данные клиента и счета для открытия
     */
    @GetMapping("/openBill")
    public String openBill(Model model, Client client, Bills bills) throws SQLException {
        model.addAttribute("client", client);
        model.addAttribute("bills", bills);
        return "openBill";
    }

    /**
     * Окно вснесения денег на счета клиента
     *
     * @return вводяться данные счета и сумма для внесения
     */
    @GetMapping("/deposit")
    public String depositTransactions(Model model, Transactions transactions, Bills bills) throws SQLException {
        model.addAttribute("transactions", transactions);
        model.addAttribute("bills", bills);
        return "deposit";
    }

    /**
     * Окно снятия денег со счета клиента
     *
     * @return вводяться данные счета и сумма для снятия
     */
    @GetMapping("/withdraw")
    public String withdrawTransactions(Model model, Transactions transactions, Bills bills) throws SQLException {
        model.addAttribute("transactions", transactions);
        model.addAttribute("bills", bills);
        return "withdraw";
    }

    /**
     * Окно создания нового счета клиента
     *
     * @return вводяться данные клиента и сумма для зачисления на новый счет
     */
    @GetMapping("/newBill")
    public String newBill(Model model, Client client, Bills bills) throws SQLException {
        model.addAttribute("client", client);
        model.addAttribute("bills", bills);
        return "newBill";
    }

    /**
     * Пост запрос для открытия данных клиента
     *
     * @return Открываються данные клиента
     */
    @RequestMapping(method = RequestMethod.POST)
    @PostMapping("/openClient")
    public String openClientSuccess(Model model, @ModelAttribute(value = "client") Client client) throws SQLException {
        Client client2 = clientService.getClientService(client);
        model.addAttribute("client2", client2);
        return "openClientSuccess";
    }

    /**
     * Пост запрос для создания нового клиента
     *
     * @return Создаеться новый клиента
     */
    @PostMapping("/newClient")
    public String newClientSuccess(Model model, @ModelAttribute(value = "client") Client client) throws SQLException {
        Client client2 = clientService.addClientService(client);
        model.addAttribute("client2", client2);
        return "newClientSuccess";
    }

    /**
     * Пост запрос для открытия счета клиента
     *
     * @return Открываються данные счета клиента
     */
    @PostMapping("/openBill")
    public String openBillSuccess(Model model, @ModelAttribute(value = "client") Client client, @ModelAttribute(value = "bills") Bills bills) throws SQLException {
        Bills bills2 = billService.getBillService(clientService.getIdClientService(client), bills.getNum_Bill());
        model.addAttribute("bills2", bills2);
        return "openBillSuccess";
    }

    /**
     * Пост запрос для создания нового счета клиента
     *
     * @return Создаеться новый счет клиента
     */
    @PostMapping("/newBill")
    public String newBillSuccess(Model model, @ModelAttribute(value = "client") Client client, @ModelAttribute(value = "bills") Bills bills) throws SQLException {

        billService.addBillService(clientService.getIdClientService(client), bills.getSum_Bills(), bills.getData_Begin());
        return "newBillSuccess";
    }

    /**
     * Пост запрос для снятия со счета клиента
     *
     * @return Происходит снятие денежных средств
     */
    @PostMapping("/withdraw")
    public String withdrawTransactionsSuccess(Model model, @ModelAttribute(value = "transactions") Transactions transactions, @ModelAttribute(value = "bills") Bills bills) throws SQLException {
        transactionService.saveTransactionsService(bills.getNum_Bill(), (-1) * transactions.getSum_Transaction(), transactions.getData_Transaction());
        billService.changeSum(bills.getNum_Bill(), (-1) * transactions.getSum_Transaction());
        return "withdrawSuccess";
    }

    /**
     * Пост запрос для внесения на счета клиента
     *
     * @return Происходит внесение денежных средств
     */
    @PostMapping("/deposit")
    public String depositTransactionsSuccess(Model model, @ModelAttribute(value = "transactions") Transactions transactions, @ModelAttribute(value = "bills") Bills bills) throws SQLException {
        transactionService.saveTransactionsService(bills.getNum_Bill(), transactions.getSum_Transaction(), transactions.getData_Transaction());
        billService.changeSum(bills.getNum_Bill(), transactions.getSum_Transaction());
        return "depositSuccess";
    }

}

