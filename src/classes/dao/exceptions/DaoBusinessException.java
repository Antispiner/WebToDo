package classes.dao.exceptions;

/**
 * Created by treve on 03.05.2018.
 */
public class DaoBusinessException extends DaoException {

    public DaoBusinessException(String message) {
        super(message);
    }

    public DaoBusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
