package classes.servlets.servlet;

import classes.dao.exceptions.DaoException;
import classes.interfases.AbstractServlet;
import classes.model.User;
import classes.service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.ValidationException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

import static classes.constants.AllConstants.*;


/**
 * Created by treve on 04.04.2018.
 */
public class RegistrationServlet extends AbstractServlet {

    Service service = new Service();

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User u = this.execute("registration.jsp", req, resp);
        service.getUser(u);



        String name;
        try {
            name = service.checkUserDB();
            if (!name.equals(USER_NOT_FOUND)) {

                this.forwardErrorTo(REGISTRATION_JSP, USER_IS_EXIST, req, resp);
            } else {
                String res = service.registerUser();
                if (!res.equals(USER_NOT_REGISTR)) {

                    HttpSession session = req.getSession();
                    session.setAttribute(USER_NAME, u);

                    this.forwardToUser(TODAY_JSP,  req, resp);
                } else {
                    this.forwardErrorTo(REGISTRATION_JSP, res, req, resp);

                }
            }

        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
