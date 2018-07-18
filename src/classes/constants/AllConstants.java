package classes.constants;

/**
 * Created by treve on 03.05.2018.
 */
public class AllConstants {
    //db
    public static final String INSERT_USER = "INSERT INTO users (login, password) VALUES(?,?)";
    public static final String READ_USER = "SELECT  login, password FROM users WHERE login=? AND password=?";
    public static final String SELECT_TASKS = "SELECT  * FROM tasks WHERE userName = ?";
    public static final String CREATE_TASK = "INSERT INTO tasks (userName,content,flag,someDate) VALUES(?,?,?,?)";
    public static final String DELETE_TASK = "DELETE FROM tasks WHERE flag =? AND id = ?";
    public static final String UPDATE_TASK = "UPDATE tasks SET flag = ? WHERE flag =? AND id = ?";
    public static final String SET_FILE = "UPDATE tasks SET filename=? WHERE id=?";
    public static final String DELETE_FILE = "UPDATE tasks SET filename= DEFAULT WHERE id=?";

    //jsp
    public static final String TODAY_JSP = "/view/today.jsp";
    public static final String TOMORROW_JSP = "/view/tomorrow.jsp";
    public static final String SOMEDAY_JSP = "/view/someday.jsp";
    public static final String FIXED_JSP = "/view/fixed.jsp";
    public static final String RECYCLE_BIN_JSP = "/view/recycle.jsp";
    public static final String LOGIN_JSP = "/view/login.jsp";
    public static final String REGISTRATION_JSP = "/view/registration.jsp";

    //status
    public static final String LOGIN_EMPTY = "Login is empty";
    public static final String PASSWORD_EMPTY = "Password is empty";
    public static final String STATUS_OK = "OK";
    public static final String ERROR_LOGIN_OR_PASSWORD = "Login or password are absent";
    public static final String USER_NOT_FOUND = "User is not found in DB!";
    public static final String USER_NOT_REGISTR = "User is not registration";
    public static final String USER_IS_EXIST = "User is not registration";




    //
    public static final String ENTRY_LOGIN = "login";
    public static final String ENTRY_PASSWORD = "password";
    public static final String ATTRIBUTE = "Message";
    public static final String USER_NAME = "UserName";
    public static final String PAGE = "page";
    public static final String CHECK = "CheckTask";
    public static final String FILE = "file";
    public static final String CONTENT = "check";
    public static final String TYPE = "type";
    public static final String TARGET = "target";
    public static final String DATE = "dat";
    public static final String FILE_NAME = "filename";


    //action
    public static final String RECYCLE_BIN ="RECYCLE_BIN";
    public static final String FIXED = "FIXED";
    public static final String DELETE = "DELETE";
    public static final String UPLOAD = "UPLOAD";
    public static final String DELETE_FILES = "DELETE_FILE";
    public static final String DOWNLOAD = "DOWNLOAD";
    public static final String TODAY = "TODAY";
    public static final String TOMORROW = "TOMORROW";
    public static final String SOMEDAY = "SOMEDAY";

    //flags
    public static final String WORK = "work";
    public static final String RECYCLE = "recycle";
    public static final String FIX = "fixed";


    //path
    public static final String APP_PATH = "A:/Programming/web/loadFiles";


    //
    public static final String CONTENT_DISP = "content-disposition";


}
