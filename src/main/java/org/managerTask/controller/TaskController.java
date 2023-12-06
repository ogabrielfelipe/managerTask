package org.managerTask.controller;

import org.managerTask.model.Task;
import org.managerTask.util.ConnectorJDBC;

import java.sql.*;
import java.util.ArrayList;

public class TaskController {
    static ConnectorJDBC connJDBC;
    public TaskController(){
        connJDBC = new ConnectorJDBC();
    }

    public void listTasks(){
        String sql = "SELECT * FROM Task";
        try {
            Connection connDB = connJDBC.getConnection();
            Statement statement = connDB.createStatement();
            ResultSet result = statement.executeQuery(sql);

            ArrayList<Task> tasks = new ArrayList<Task>();
            int count = 1;
            while (result.next()){
                Task task = new Task();
                task.setSubject(result.getString("subject"));
                task.setDescription(result.getString("description"));
                task.setStatus(result.getBoolean("status"));
                task.setIdTask(result.getInt("id_task"));
                tasks.add(task);
                count++;
            }
            connJDBC.close();
            showListTasks(tasks);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public Task findTask(int idTask){
        String sql = "SELECT * FROM Task WHERE id_task= ?";
        try {
            Connection connDB = connJDBC.getConnection();
            PreparedStatement  statement = connDB.prepareStatement(sql);
            statement.setInt(1, idTask);
            ResultSet result = statement.executeQuery();

            Task task = new Task();
            while (result.next()){
                task.setSubject(result.getString("subject"));
                task.setDescription(result.getString("description"));
                task.setStatus(result.getBoolean("status"));
                task.setIdTask(result.getInt("id_task"));
            }
            connJDBC.close();
            return task;

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void createTask(Task task){
        String sql = "INSERT INTO Task (subject, description, status) VALUES (?,?,?)";

        try {
            Connection connDB = connJDBC.getConnection();
                PreparedStatement statement = connDB.prepareStatement(sql);
                statement.setString(1, task.getSubject());
                statement.setString(2, task.getDescription());
                statement.setBoolean(3, task.getStatus());
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Tarefa inserida com sucesso!");
                }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateTask(Task task){
        Task taskUpdate = findTask(task.getId());
        String sql = "UPDATE task SET subject =?, description=?, status=? WHERE id_task=?";
        try {
            Connection connDB = connJDBC.getConnection();
            PreparedStatement statement = connDB.prepareStatement(sql);
            statement.setString(1, task.getSubject());
            statement.setString(2, task.getDescription());
            statement.setBoolean(3, task.getStatus());
            statement.setInt(4, taskUpdate.getId());
            int taskUpdated = statement.executeUpdate();
            if (taskUpdated > 0) {
                System.out.println("Tarefa atualizada com sucesso!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteTask(int idTask){
        Task task = findTask(idTask);
        if (task.getSubject().isEmpty()){
            System.out.println("Tarefa não encontrada.");
            return;
        }
        String sql = "DELETE FROM task WHERE id_task = ?";
        try {
            Connection connDB = connJDBC.getConnection();
            PreparedStatement statement = connDB.prepareStatement(sql);
            statement.setInt(1, task.getId());
            int taskDeleted = statement.executeUpdate();
            if (taskDeleted > 0){
                System.out.println("Tarefa deletada com sucesso!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }

    static void showListTasks(ArrayList<Task> tasks){
        System.out.print(" | ");
        System.out.print("idTask");
        System.out.print(" | ");
        System.out.print("Assunto");
        System.out.print(" | ");;
        System.out.print("Descrição");
        System.out.print(" | ");;
        System.out.print("Status");
        System.out.print(" | \n");
        for (int i = 0; i < tasks.size(); i++){
            System.out.print(" | ");
            System.out.print(tasks.get(i).getId());
            System.out.print(" | ");
            System.out.print(tasks.get(i).getSubject());
            System.out.print(" | ");;
            System.out.print(tasks.get(i).getDescription());
            System.out.print(" | ");;
            System.out.print(tasks.get(i).getStatus());
            System.out.print(" | \n");
        }
    }
}
