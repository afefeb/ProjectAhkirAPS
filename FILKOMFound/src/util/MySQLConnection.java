package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    private static final String PROPERTIES_FILE = "util/key.txt";
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = MySQLConnection.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            if (input == null) {
                throw new RuntimeException("Configuration file not found: " + PROPERTIES_FILE);
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load database configuration", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                properties.getProperty("url"),
                properties.getProperty("user"),
                properties.getProperty("password")
        );
    }
}
