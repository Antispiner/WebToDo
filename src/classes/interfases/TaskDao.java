package classes.interfases;

import classes.dao.exceptions.DaoException;
import classes.model.Task;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by treve on 07.04.2018.
 */
public interface TaskDao {
    List<Task> getTasksInBD(String name) throws DaoException;

    void createTask(Task task) throws DaoException;

    void deleteTasks(List<Task> task, String check) throws DaoException;

    void updateTasks(List<Task> task, String check) throws DaoException;

    void setFileNameToTask(List<Task> task, String fileName) throws DaoException;

    void deleteFileNameToTask(List<Task> task, String fileName) throws DaoException;

}
