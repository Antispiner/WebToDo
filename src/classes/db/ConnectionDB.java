package classes.db;

import classes.dao.exceptions.DaoException;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by treve on 05.04.2018.
 */
public class ConnectionDB {

    public Connection getConnection() throws ClassNotFoundException, SQLException, IOException {
        return initConnection();
    }

    public void closeResources(AutoCloseable... resources) throws DaoException {
        try {
            for (AutoCloseable resource : resources) {
                if (resource != null) {
                    resource.close();
                }
            }
        } catch (Exception e) {
            throw new DaoException(e.getMessage());
        }
    }


    private Connection initConnection()
            throws ClassNotFoundException, SQLException, IOException {

        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String JDBC_URL = "jdbc:mysql://localhost:3306/todolist";
        final String JDBC_NAME = "root";
        final String JDBC_PASSWORD = "";

        Class.forName(JDBC_DRIVER);

        return DriverManager.getConnection(JDBC_URL, JDBC_NAME, JDBC_PASSWORD);

    }


}
