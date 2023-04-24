package model.dao.iplm;


import model.dao.IConnectionDAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDAO implements IConnectionDAO {
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/ENJOY_GALAXY";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "123456";
    public static ConnectionDAO getInstance(){
        return new ConnectionDAO();
    }
    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
