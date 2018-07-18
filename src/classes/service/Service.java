package classes.service;

import classes.dao.ImplDAO;
import classes.dao.exceptions.DaoException;
import classes.interfases.IDao;
import classes.model.User;

import java.sql.SQLException;

import static classes.constants.AllConstants.USER_NOT_FOUND;
import static classes.constants.AllConstants.USER_NOT_REGISTR;


/**
 * Created by treve on 04.04.2018.
 */
public class Service {
    private IDao dao = new ImplDAO();
    private User user;

    public void getUser(User user) {
        this.user = user;
    }


    public String checkUserDB() throws DaoException {
        String rr = dao.read(user);
        return check(USER_NOT_FOUND, rr);
    }

    public String registerUser() throws DaoException {
        String rr = dao.create(user);
        return check(USER_NOT_REGISTR, rr);
    }

    private String check(String message, String result) {
        return (result != null) ? result : message;
    }

}