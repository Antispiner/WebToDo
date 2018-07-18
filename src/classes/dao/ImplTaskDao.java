package classes.dao;

import classes.constants.ErrorMessages;
import classes.dao.exceptions.DaoException;
import classes.db.ConnectionDB;
import classes.interfases.TaskDao;
import classes.model.Task;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import static classes.constants.AllConstants.*;

/**
 * Created by treve on 07.04.2018.
 */
public class ImplTaskDao implements TaskDao {
    private final ConnectionDB connectionDB = new ConnectionDB();

    @Override
    public List<Task> getTasksInBD(String name) throws DaoException {
        List<Task> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps;
        ResultSet resultSet = null;

        try {
            connection = connectionDB.getConnection();
            ps = connection.prepareStatement(SELECT_TASKS);
            ps.setString(1, name);

            resultSet = ps.executeQuery();

            while (resultSet.next()) {

                int id = resultSet.getInt(1);
                String userName = resultSet.getString(2);
                String content = resultSet.getString(3);
                String flag = resultSet.getString(4);
                String dayTask = resultSet.getString(5);
                String filename = resultSet.getString(6);

                list.add(new Task(id, userName, content, flag, dayTask, filename));
            }
            return list;

        } catch (IOException | ClassNotFoundException e) {
            throw new DaoException(ErrorMessages.ERROR_DB_CONNECT);

        } catch (SQLException e) {
            throw new DaoException(ErrorMessages.ERROR_QUERY);

        } finally {
            connectionDB.closeResources(connection, resultSet);
        }

    }

    @Override
    public void createTask(Task task) throws DaoException {
        Connection connection = null;
        PreparedStatement ps;

        try {

            connection = connectionDB.getConnection();

            ps = connection.prepareStatement(CREATE_TASK);

            ps.setString(1, task.getUserName());
            ps.setString(2, task.getContent());
            ps.setString(3, task.getFlag());
            ps.setString(4, task.getDate());

            ps.executeUpdate();


        } catch (IOException | ClassNotFoundException e) {
            throw new DaoException(ErrorMessages.ERROR_DB_CONNECT);

        } catch (SQLException e) {
            throw new DaoException(ErrorMessages.ERROR_QUERY);

        } finally {
            connectionDB.closeResources(connection);
        }

    }

    @Override
    public void deleteTasks(List<Task> task, String flag) throws DaoException {
        Connection connection = null;
        PreparedStatement ps;

        try {
            connection = connectionDB.getConnection();
            ps = connection.prepareStatement(DELETE_TASK);

            for (Task currentTask : task) {


                ps.setString(1, currentTask.getFlag());
                ps.setInt(2, currentTask.getId());
                ps.executeUpdate();
            }


        } catch (IOException | ClassNotFoundException e) {
            throw new DaoException(ErrorMessages.ERROR_DB_CONNECT);

        } catch (SQLException e) {
            throw new DaoException(ErrorMessages.ERROR_QUERY);

        } finally {
            connectionDB.closeResources(connection);
        }
    }

    @Override
    public void updateTasks(List<Task> task, String flag) throws DaoException {
        Connection connection = null;
        PreparedStatement ps;

        try {
            connection = connectionDB.getConnection();
            ps = connection.prepareStatement(UPDATE_TASK);

            for (Task currentTask : task) {

                ps.setString(1, flag);
                ps.setString(2, currentTask.getFlag());
                ps.setInt(3, currentTask.getId());
                ps.executeUpdate();
            }

        } catch (IOException | ClassNotFoundException e) {
            throw new DaoException(ErrorMessages.ERROR_DB_CONNECT);

        } catch (SQLException e) {
            throw new DaoException(ErrorMessages.ERROR_QUERY);

        } finally {
            connectionDB.closeResources(connection);
        }


    }

    @Override
    public void setFileNameToTask(List<Task> task, String fileName) throws DaoException {
        Connection connection = null;
        PreparedStatement ps;


        try {
            connection = connectionDB.getConnection();
            ps = connection.prepareStatement(SET_FILE);
            for (Task currentTask : task) {
                ps.setString(1, fileName);
                ps.setInt(2, currentTask.getId());
                ps.executeUpdate();
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new DaoException(ErrorMessages.ERROR_DB_CONNECT);

        } catch (SQLException e) {
            throw new DaoException(ErrorMessages.ERROR_QUERY);

        } finally {
            connectionDB.closeResources(connection);
        }
    }

    @Override
    public void deleteFileNameToTask(List<Task> task, String fileName) throws DaoException {
        Connection connection = null;
        PreparedStatement ps;


        try {
            connection = connectionDB.getConnection();
            ps = connection.prepareStatement(DELETE_FILE);
            for (Task currentTask : task) {
                ps.setInt(1, currentTask.getId());
                ps.executeUpdate();
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new DaoException(ErrorMessages.ERROR_DB_CONNECT);

        } catch (SQLException e) {
            throw new DaoException(ErrorMessages.ERROR_QUERY);

        } finally {
            connectionDB.closeResources(connection);
        }
    }


}
