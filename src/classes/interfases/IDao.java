package classes.interfases;

import classes.dao.exceptions.DaoException;
import classes.model.User;


/**
 * Created by treve on 04.04.2018.
 */
public interface IDao {
    String create(User user) throws DaoException;

    String read(User user) throws DaoException;

}
