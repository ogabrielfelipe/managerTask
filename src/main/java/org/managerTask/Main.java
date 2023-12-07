package org.managerTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.managerTask.controller.TaskController;
import org.managerTask.model.Task;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        TaskController taskController = new TaskController();
        int optionSelected = 0;

        Scanner sc = new Scanner(System.in);


        while(optionSelected != 9){
            System.out.println("\n ________________________________________________________");
            System.out.println("Selecione uma das opções abaixo:");
            System.out.println("[1] Cadastrar uma Tarefa.");
            System.out.println("[2] Alterar uma Tarefa.");
            System.out.println("[3] Excluir uma Tarefa.");
            System.out.println("[4] Filtrar por uma Tarefa.");
            System.out.println("[5] Listar todas as Tarefas.");
            System.out.println("[9] Sair.");
            System.out.println("________________________________________________________ \n");

            System.out.println(">>");
            optionSelected = sc.nextInt();

            String subject = "";
            String description = "";
            String status = "";

            switch (optionSelected){
                case 1:
                    System.out.print("Assunto: \t");
                    subject = sc.nextLine();
                    sc.next();

                    System.out.print("\nDescrição: \t");
                    description = sc.nextLine();
                    sc.next();

                    System.out.print("\nAtivo (1 = Sim | 0 = Não): \t");
                    status = sc.nextLine();
                    sc.next();

                    boolean statusAux = false;
                    statusAux = status.equals("1");

                    Task taskForCreate = new Task(subject, description, statusAux);
                    taskController.createTask(taskForCreate);

                    System.out.println("\n");
                    taskController.listTasks();
                    break;
                case 2:
                    int idTask = 4;
                    Task taskForUpdate = new Task("Testando assundo 124", "Descrição do assunto 1145", false);
                    taskForUpdate.setIdTask(idTask);
                    taskController.updateTask(taskForUpdate);
                    taskController.listTasks();
                    break;
                case 3:
                    int idTaskForDelete = 4;
                    taskController.deleteTask(idTaskForDelete);
                    break;
                case 4:
                    Task task = taskController.findTask(1);
                    break;
                case 5:
                    taskController.listTasks();
                    break;
                default:
                    break;

            }
        }
/*

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
*/
    }



}