package appMain.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Класс Репозиторий "Подключение к базе данных".
 *
 * @author Пьянзин Андрей
 * @version 1.1
 * @since 12.03.2021
 */
public class ConnectionPostrgres {
    public Connection connection;
    public Statement statement;

    /**
     * метод подключаеться к базе(PostgreSQL)
     */
    public void connect() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?user=postgres&password=root4905");
            statement = connection.createStatement();

        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Unable to connect");
        }

    }

    /**
     * метод отключаеться от базы(PostgreSQL)
     */
    public void disconnect() throws SQLException {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

