import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyJDBC {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/try_schema";
    private static final String USER = "root";
    private static final String PASSWORD = "hehe"; // Ganti dengan password Anda

    // Metode untuk mendapatkan koneksi
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
