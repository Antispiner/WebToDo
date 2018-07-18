package classes.service;

import classes.dao.ImplTaskDao;
import classes.dao.exceptions.DaoException;
import classes.interfases.TaskDao;
import classes.model.Task;
import classes.taskLogic.Parser;

import java.util.List;

import static classes.constants.AllConstants.*;

/**
 * Created by treve on 07.04.2018.
 */
public class ServiceTasks {
    TaskDao dao = new ImplTaskDao();
    Task task;

    public Task getTask(Task task) {
        return this.task = task;
    }

    public void createTaskDB() throws  DaoException {

        dao.createTask(task);
    }

    public List<Task> getAllTasks(String name) throws  DaoException {
        List<Task> list = dao.getTasksInBD(name);
        Parser parser = new Parser();
        parser.parseAllTasks(list);

        return  list;
    }

   public List<Task> getCheckedTask(String[] list, String action, List<Task> tasks, String filename){
       Parser parser = new Parser();
       List<Task> taskList = null;
       try {
           taskList = parser.parseSelectedTasks(list,tasks);
           if (RECYCLE_BIN.equals(action)) {
               dao.updateTasks(taskList, "recycle");
           }
           if (FIXED.equals(action)) {
               dao.updateTasks(taskList, "fixed");
           }

           if (DELETE.equals(action)){
               dao.deleteTasks(taskList,"recycle");
           }
           if (UPLOAD.equals(action)){
               dao.setFileNameToTask(taskList, filename);
           }
           if (DELETE_FILES.equals(action)){
               dao.deleteFileNameToTask(taskList, filename);
           }

       } catch (Exception e) {
           e.printStackTrace();
       }
       return taskList;
   }





}
