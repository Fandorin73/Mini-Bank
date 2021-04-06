package appMain;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
/**
 * Проект Мини-Банк
 *
 * @author Пьянзин Андрей
 * @version 1.1
 * @since 12.03.2021
 */
@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class BankApp {
    public static void main(String[] args) {
        SpringApplication.run(BankApp.class, args);
    }
}
