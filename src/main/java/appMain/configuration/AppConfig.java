package appMain.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * AppConfig - класс конфигурации(показывает где искать  аннотированные классы)
 */
@Configuration
@ComponentScan("appMain")
public class AppConfig {
}