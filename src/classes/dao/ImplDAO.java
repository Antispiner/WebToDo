package classes.dao;

import classes.constants.ErrorMessages;
import classes.dao.exceptions.DaoException;
import classes.db.ConnectionDB;
import classes.interfases.IDao;
import classes.model.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static classes.constants.AllConstants.INSERT_USER;
import static classes.constants.AllConstants.READ_USER;

/**
 * Created by treve on 04.04.2018.
 */
public class ImplDAO implements IDao {
    ConnectionDB connectionDB = new ConnectionDB();


    @Override
    public String create(User user) throws DaoException {
        String login = null;
        Connection connection = null;
        PreparedStatement ps;

        try {

            connection = connectionDB.getConnection();
            synchronized (ImplDAO.class) {
                ps = connection.prepareStatement(INSERT_USER);
                ps.setString(1, user.getLogin());
                ps.setString(2, user.getPassword());
                ps.executeUpdate();

            }
            login = user.getLogin();
        } catch (IOException | ClassNotFoundException e) {
            throw new DaoException(ErrorMessages.ERROR_DB_CONNECT);

        } catch (SQLException e) {
            throw new DaoException(ErrorMessages.ERROR_QUERY);

        } finally {
            connectionDB.closeResources(connection);
        }
        return login;
    }

    @Override
    public String read(User user) throws DaoException {
        Connection connection = null;
        PreparedStatement ps;
        ResultSet resultSet = null;
        String login = null;
        try {
            connection = connectionDB.getConnection();
            ps = connection.prepareStatement(READ_USER);
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            resultSet = ps.executeQuery();

            while (resultSet.next()) {

                login = resultSet.getString(1);

            }
        } catch (IOException | ClassNotFoundException e) {
            throw new DaoException(ErrorMessages.ERROR_DB_CONNECT);

        } catch (SQLException e) {
            throw new DaoException(ErrorMessages.ERROR_QUERY);

        } finally {
            connectionDB.closeResources(connection, resultSet);
        }
        return login;
    }


}
