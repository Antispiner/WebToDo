package classes.interfases;

import classes.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

import static classes.constants.AllConstants.*;

/**
 * Created by treve on 04.04.2018.
 */
public abstract class AbstractServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();

    }

    protected void forwardErrorTo(String url, String message, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute(ATTRIBUTE, message);
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
    }

    protected void forwardToUser(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = this.getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);


    }

    private String checkLoginPassword(String login, String password) {
        if (login != null && password != null) {
            login = login.trim();
            return "".equals(login) ? LOGIN_EMPTY : ("".equals(password) ? PASSWORD_EMPTY : STATUS_OK);
        } else {
            return ERROR_LOGIN_OR_PASSWORD;
        }
    }


    protected User execute(String pageName, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter(ENTRY_LOGIN);
        String password = req.getParameter(ENTRY_PASSWORD);
        String check = this.checkLoginPassword(login, password);

        if (!Objects.equals(check, STATUS_OK)) {
            this.forwardErrorTo("/view/" + pageName, check, req, resp);
        }

        return new User(login, password);
    }


}
