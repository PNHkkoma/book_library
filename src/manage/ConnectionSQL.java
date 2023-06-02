package manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQL {
    public static Connection getConnection() {
        final String URL = "jdbc:mysql://localhost:3306/book_manage";
        final String USER = "root";
        final String PASSWORD = "hung7aVIP";
        try {
            // Class.forName("com.mysql.jdbc.Driver");
            System.out.println("connect successfully!");
            return DriverManager.getConnection(URL, USER, PASSWORD);
            // }catch(ClassNotFoundException e){
            // e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
