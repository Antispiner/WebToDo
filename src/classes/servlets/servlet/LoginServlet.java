package classes.servlets.servlet;

import classes.dao.exceptions.DaoException;
import classes.interfases.AbstractServlet;
import classes.model.Task;
import classes.model.User;
import classes.service.Service;
import classes.service.ServiceTasks;
import classes.taskLogic.Parser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static classes.constants.AllConstants.*;

/**
 * Created by treve on 04.04.2018.
 */
public class LoginServlet extends AbstractServlet {
    Service service = new Service();
    ServiceTasks serviceTasks = new ServiceTasks();

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        User u = this.execute("login.jsp", req, resp);
        service.getUser(u);

        HttpSession session = req.getSession();
        session.setAttribute(USER_NAME, u);

        String name = "";
        try {
            name = service.checkUserDB();

        } catch (DaoException e) {
            e.printStackTrace();
        }

        if (!name.equals(USER_NOT_FOUND)) {

            try {
                Parser logic = new Parser();

                List<Task> list = serviceTasks.getAllTasks(u.getLogin());
                logic.parseAllTasks(list);
                session.setAttribute("TODAY", logic.getToday());
                session.setAttribute("List",list);

            } catch (DaoException e) {
                e.printStackTrace();
            }


            this.forwardToUser(TODAY_JSP, req, resp);
        } else {
            this.forwardErrorTo(LOGIN_JSP, name, req, resp);
        }


    }


}
