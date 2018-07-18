package classes.servlets.servlet;

import classes.dao.exceptions.DaoException;
import classes.enums.SectionType;
import classes.interfases.AbstractServlet;
import classes.model.Task;
import classes.model.User;
import classes.service.ServiceTasks;
import classes.taskLogic.Parser;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static classes.constants.AllConstants.PAGE;
import static classes.constants.AllConstants.USER_NAME;

/**
 * Created by treve on 09.04.2018.
 */
@MultipartConfig
public class DistributionServlet extends AbstractServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        User currentUser = (User) session.getAttribute(USER_NAME);
        String page = req.getParameter(PAGE);

        ServiceTasks serviceTasks = new ServiceTasks();

        try {
            List<Task> list = serviceTasks.getAllTasks(currentUser.getLogin());
            Parser logic = new Parser();

            logic.parseAllTasks(list);
            session.setAttribute("TODAY", logic.getToday());
            session.setAttribute("TOMORROW", logic.getTomorrow());
            session.setAttribute("SOMEDAY", logic.getSomeday());
            session.setAttribute("FIXED", logic.getFixed());
            session.setAttribute("RECYCLE_BIN", logic.getRecycle());
            this.forwardToUser(String.valueOf(SectionType.valueOf(page).getSomePage()), req, resp);
        } catch (DaoException e) {
            e.printStackTrace();
        }

    }
}
