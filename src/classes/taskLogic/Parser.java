package classes.taskLogic;

import classes.model.Task;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import static classes.constants.AllConstants.*;
import static classes.constants.ErrorMessages.ERROR;

/**
 * Created by treve on 10.04.2018.
 */
public class Parser {

    private String[] getDate(String d) {
        return d.split("-");
    }

    public String parseStringDate(String date, String flag) {
        String[] sDate = getDate(date);

        int year = Integer.parseInt(sDate[0]);
        int month = Integer.parseInt(sDate[1]);
        int day = Integer.parseInt(sDate[2]);

        Calendar calendar = new GregorianCalendar(year, month - 1, day);
        Calendar todayCal = new GregorianCalendar();
        Calendar tomorrowCal = new GregorianCalendar();

        tomorrowCal.add(5, 1);

        String result = "";

        if (todayCal.compareTo(calendar) == 1 && flag.equals(WORK)) {
            result = TODAY;
        } else if (tomorrowCal.compareTo(calendar) == 1 && flag.equals(WORK)) {
            result = TOMORROW;
        } else if (tomorrowCal.before(calendar) && flag.equals(WORK)) {
            result = SOMEDAY;
        } else if (flag.equals(RECYCLE)) {
            result = RECYCLE_BIN;
        } else if (flag.equals(FIX)) {
            result = FIXED;
        }

        return result;
    }

    public static String parseObDate(String page, String value) {
        String result;

        Calendar date = new GregorianCalendar();
        if (page.equals(TODAY)) {
            date = new GregorianCalendar();
        }
        if (page.equals(TOMORROW)) {
            date.add(5, 1);
        }
        if (page.equals(SOMEDAY)) {

            return value;
        }
        SimpleDateFormat e = new SimpleDateFormat("yyyy-MM-dd");
        result = e.format(date.getTime());
        return result;
    }

    private List<Task> today = new ArrayList<>();
    private List<Task> tomorrow = new ArrayList<>();
    private List<Task> someday = new ArrayList<>();
    private List<Task> fixed = new ArrayList<>();
    private List<Task> recycle = new ArrayList<>();

    public List<Task> getToday() {
        return today;
    }

    public List<Task> getTomorrow() {
        return tomorrow;
    }

    public List<Task> getSomeday() {
        return someday;
    }

    public List<Task> getFixed() {
        return fixed;
    }

    public List<Task> getRecycle() {
        return recycle;
    }

    public void parseAllTasks(List<Task> list) {
        for (Task e : list) {
            String res = parseStringDate(e.getDate(), e.getFlag());

            if (res.equals(TODAY)) {
                today.add(e);
            }
            if (res.equals(TOMORROW)) {
                tomorrow.add(e);
            }
            if (res.equals(SOMEDAY)) {
                someday.add(e);
            }
            if (res.equals(RECYCLE_BIN)) {
                recycle.add(e);
            }
            if (res.equals(FIXED)) {
                fixed.add(e);
            }
        }

    }

    public List<Task> parseSelectedTasks(String[] flags, List<Task> tasks) throws Exception {

        if (flags == null) {
            throw new Exception(ERROR);
        }
        List<Task> selectedList = new ArrayList<>();
        for (Task t : tasks) {
            for (String flag : flags) {

                if (t.getContent().equals(flag)) {
                    selectedList.add(t);
                }
            }
        }
        return selectedList;
    }


    public String getFileName(Part part) {
        String contentDisposition = part.getHeader(CONTENT_DISP);
        String[] items = contentDisposition.split(";");
        for (String item : items) {
            if (item.trim().startsWith(FILE_NAME)) {
                String s = item.substring(item.indexOf("=") + 1).replace("\"", "");
                return s.substring(s.lastIndexOf("\\") + 1);
            }
        }
        return null;
    }

    public void downloadFile(HttpServletResponse response, String filePath, String fileName) throws IOException {

        ServletOutputStream outputStream = null;
        BufferedInputStream inputStream = null;
        try {
            File file = new File(filePath);

            outputStream = response.getOutputStream();
            response.setContentType("Content-type: application/octet-stream\\n");
            response.setDateHeader("Expires", 0L);
            String normalizeFileName = new String(fileName.getBytes("Cp1251"), "Cp1252");

            response.setContentLength((int) file.length());
            response.addHeader("Content-Disposition", "attachment; filename=\"" + normalizeFileName + "\"");

            inputStream = new BufferedInputStream(new FileInputStream(file));

            byte[] buffer = new byte[4096];
            int bytesRead = -1;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        } finally {
            if (outputStream != null) {
                outputStream.flush();
                outputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }

    }
}
