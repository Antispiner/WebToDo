//package test;
//
//import classes.dao.ImplTaskDao;
//import classes.interfases.TaskDao;
//import classes.taskLogic.Parser;
//
//import java.sql.SQLException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.GregorianCalendar;
//
///**
// * Created by treve on 10.04.2018.
// */
//public class Main {
//    public static void main(String[] args) throws SQLException {
//
//        Calendar date = new GregorianCalendar();
//        SimpleDateFormat e = new SimpleDateFormat("yyyy/MM/dd");
//        String res = e.format(date.getTime());
//
//        System.out.println(res);
//
//        TaskDao dao = new ImplTaskDao();
//
//
//
//
//
//        Parser logic = new Parser();
//        System.out.println( dao.getTasksInBD("admin"));
//        logic.parseAllTasks( dao.getTasksInBD("admin"));
//
//        System.out.println(logic.getToday().toString());
//        System.out.println(logic.getTomorrow().toString());
//
//    }
//}
//package classes.servlets.servlet;
//
//import classes.enums.SectionType;
//import classes.interfases.AbstractServlet;
//import classes.model.Task;
//import classes.model.User;
//import classes.service.ServiceTasks;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.Date;
//import java.util.List;
//
///**
// * Created by treve on 09.04.2018.
// */
//public class DistributionServlet extends AbstractServlet {
//
//    public void doPost(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//        HttpSession session = req.getSession();
//        User currentUser = (User) session.getAttribute("UserName");
//        String page = req.getParameter("page");
//
//        ServiceTasks serviceTasks = new ServiceTasks();
//
//        // List<Task> list = serviceTasks.getAllTasks(currentUser.getLogin());
//        // session.setAttribute(page, list);
//        this.forwardToUser(String.valueOf(SectionType
//                .valueOf(page)
//                .getSomePage()), req, resp);
//
//    }
//}












//File downLoadFile = new File(filePath);
//        System.out.println("downLoadFile: " + downLoadFile);
//        FileInputStream inputStream = new FileInputStream(downLoadFile);
//        ServletContext context = getServletContext();
//
//        String mimeType = context.getMimeType(filePath);
//        if(mimeType == null) {
//        mimeType = "application/octet-stream";
//        }
//        System.out.println("MIME type: " + mimeType);
//
//        response.setContentType(mimeType);
//        response.setContentLength((int) downLoadFile.length());
//
//        String headerKey = "Content-Disposition";
//        String headerValue = String.format("attachment; filename=\"%s\"",downLoadFile.getName());
//        response.setHeader(headerKey, headerValue);
//
//        OutputStream outputStream = response.getOutputStream();
//        byte[] buffer = new byte[4096];
//        int bytesRead = -1;
//
//        while ((bytesRead = inputStream.read(buffer)) != -1) {
//        outputStream.write(buffer, 0, bytesRead);
//        }
//        inputStream.close();
//        outputStream.close();