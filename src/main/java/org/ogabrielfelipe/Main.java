package org.ogabrielfelipe;

import org.ogabrielfelipe.model.Task;
import org.ogabrielfelipe.util.ConnectorJDBC;

import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ConnectorJDBC connJDBC = new ConnectorJDBC();
        listTasks(connJDBC);
    }

    static void listTasks(ConnectorJDBC conn){
        String sql = "SELECT * FROM Task";
        try {
            Connection connDB = conn.getConnection();
            Statement statement = connDB.createStatement();
            ResultSet result = statement.executeQuery(sql);
            Task task = new Task();
            ArrayList<Task> tasks = new ArrayList<Task>();
            int count = 1;
            while (result.next()){
                task.setSubject(result.getString("subject"));
                task.setDescription(result.getString("description"));
                task.setStatus(result.getBoolean("status"));
                task.setIdTask(result.getString("idTask"));
                tasks.add(task);
                count++;
           }
            conn.close();
            showListTasks(tasks);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    static void showListTasks(ArrayList<Task> tasks){
        for (int i = 0; i < tasks.size(); i++){
            System.out.print(" | ");
            System.out.print("idTask");
            System.out.print(" | ");
            System.out.print("Assunto");
            System.out.print(" | ");;
            System.out.print("Descrição");
            System.out.print(" | ");;
            System.out.print("Status");
            System.out.print(" | \n");

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