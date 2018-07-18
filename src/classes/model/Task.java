package classes.model;

import java.util.Date;

/**
 * Created by treve on 07.04.2018.
 */
public class Task {
    private int id;
    private String userName;
    private String content;
    private String date;
    private String flag;
    private String filename;

    public Task(String userName, String content, String flag, String date) {
        this.userName = userName;
        this.content = content;
        this.date = date;
        this.flag = flag;


    }

    public Task(int id, String userName, String content, String flag, String date, String filename) {
        this.id = id;
        this.userName = userName;
        this.content = content;
        this.date = date;
        this.flag = flag;
        this.filename = filename;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getFilename() {
        return filename;
    }

    @Override
    public String toString() {
        return  content ;
    }




}
