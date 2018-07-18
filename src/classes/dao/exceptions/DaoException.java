package classes.dao.exceptions;

/**
 * Created by treve on 03.05.2018.
 */
public class DaoException extends Exception {
    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
