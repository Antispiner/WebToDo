package classes.servlets.servlet;

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
import javax.servlet.http.Part;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

import static classes.constants.AllConstants.*;

/**
 * Created by treve on 12.04.2018.
 */
@MultipartConfig
public class ActionServlet extends AbstractServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ServiceTasks serviceTasks = new ServiceTasks();
        Parser parser = new Parser();
        HttpSession session = req.getSession();
        User currentUser = (User) session.getAttribute(USER_NAME);
        String page = req.getParameter(PAGE);
        String check = req.getParameter(CHECK);
        Part part = req.getPart(FILE);
        String[] content = req.getParameterValues(CONTENT);
        List<Task> taskDownload = (List<Task>) session.getAttribute("List");


        String fileName = null;
        if (part != null) {
            fileName = parser.getFileName(part);
        }
        String filePath = APP_PATH + "/" + fileName;


        if (DOWNLOAD.equals(check)) {
            for (Task t : taskDownload) {
                for (String flag : content) {
                    if (t.getContent().equals(flag)) {
                        parser.downloadFile(resp, filePath, t.getFilename());
                    }
                }
            }

        }

        if (fileName != null && !fileName.isEmpty()) {
            part.write(filePath);
        }

        try {

            List<Task> list = serviceTasks.getAllTasks(currentUser.getLogin());
            String[] selectedCheck = req.getParameterValues(CONTENT);

            serviceTasks.getCheckedTask(selectedCheck, check, list, fileName);

            Parser logic = new Parser();
            List<Task> list2 = serviceTasks.getAllTasks(currentUser.getLogin());

            logic.parseAllTasks(list2);
            session.setAttribute("List", list);
            session.setAttribute("TODAY", logic.getToday());
            session.setAttribute("TOMORROW", logic.getTomorrow());
            session.setAttribute("SOMEDAY", logic.getSomeday());
            session.setAttribute("FIXED", logic.getFixed());
            session.setAttribute("RECYCLE_BIN", logic.getRecycle());

            this.forwardToUser(String.valueOf(SectionType.valueOf(page).getSomePage()), req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
