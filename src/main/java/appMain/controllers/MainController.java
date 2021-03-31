package appMain.controllers;
import appMain.repositories.ClientRepository;
import appMain.repositories.ConnectionPostrgres;
import appMain.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.ResultSet;
import java.sql.SQLException;

@Controller
@RequestMapping("/main")
public class MainController {

    @GetMapping
    public String main() {
       return "main";
    }
    @GetMapping("/newClient")
    public String newClient() {
        return "newClient";
    }
    @GetMapping("/openClient")
    public String openClient() throws SQLException {

        return "openClient";
    }

}
/* ResultSet resultSet = connectionPostrgres.statement.executeQuery("SELECT * FROM Client  WHERE Name = name and Pasport_Serial=SerPas and Pasport_Number =NumPas;");

        while(resultSet.next()){

            int id = resultSet.getInt(1);
            String namePas = resultSet.getString(2);
            int serPas = resultSet.getInt(3);
            int numPas = resultSet.getInt(4);
            System.out.printf("%d. %s - %d \n", id, namePas, serPas,numPas);
        }*/