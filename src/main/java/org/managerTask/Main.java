package org.managerTask;

import org.managerTask.controller.TaskController;
import org.managerTask.model.Task;
import org.managerTask.util.ConnectorJDBC;

import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TaskController taskController = new TaskController();

        // CRIAR UMA TASK
        Task taskForCreate = new Task("Testando assundo 1", "Descrição do assunto 1", true);
        taskController.createTask(taskForCreate);
        taskController.listTasks();

        //UPDATE TASK
        int idTask = 4;
        Task taskForUpdate = new Task("Testando assundo 124", "Descrição do assunto 1145", false);
        taskForUpdate.setIdTask(idTask);
        taskController.updateTask(taskForUpdate);
        taskController.listTasks();

        //BUSCAR UMA TASK
        Task task = taskController.findTask(1);

        //DELETE TASK
        int idTaskForDelete = 4;
        taskController.deleteTask(idTaskForDelete);


        //LISTAR TODAS AS TASKS
        taskController.listTasks();

    }



}