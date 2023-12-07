package org.managerTask;

import org.managerTask.controller.TaskController;
import org.managerTask.model.Task;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
       int optionSelected = 0;

        Scanner sc = new Scanner(System.in);
        TaskController taskController = new TaskController();

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

            System.out.print(">> ");
            optionSelected = sc.nextInt();



            switch (optionSelected){
                case 1:
                    createTask(sc, taskController);
                    break;
                case 2:
                    updateTask(sc, taskController);
                    break;
                case 3:
                    deleteTask(sc, taskController);
                    break;
                case 4:
                    findTask(sc, taskController);
                    break;
                case 5:
                    showTasks(taskController);
                    break;
                default:
                    break;

            }
        }

    }

    private static void createTask(Scanner sc, TaskController taskController){
        System.out.println("\n ==== Cadastrando uma tarefa ====");
        System.out.print("Assunto: \t");
        String subject = sc.next();

        System.out.print("Descrição: \t");
        String description = sc.next();

        System.out.print("Ativo (1 = Sim | 0 = Não): \t");
        String statusInp = sc.next();

        boolean status = false;
        status = statusInp.equals("1");

        Task taskForCreate = new Task(subject, description, status);
        taskController.createTask(taskForCreate);

        System.out.println("\n");
        taskController.listTasks();
    }

    private static void updateTask(Scanner sc, TaskController taskController){
        System.out.println("\n ==== Alterando uma tarefa ====");

        System.out.println("Qual desses cadastros deseja alterar?");
        taskController.listTasks();

        System.out.print("Digite o Código de Identificação (idTask): ");
        int idTask = Integer.parseInt(sc.next());

        System.out.print("Assunto: ");
        String subject = sc.next();

        System.out.print("Descrição: \t");
        String description = sc.next();

        System.out.print("Ativo (1 = Sim | 0 = Não): \t");
        String statusInp = sc.next();

        boolean status = false;
        status = statusInp.equals("1");

        Task taskForUpdate = new Task(subject, description, status);
        taskForUpdate.setIdTask(idTask);
        taskController.updateTask(taskForUpdate);


        System.out.println("\n");
        taskController.listTasks();
    }

    private static void deleteTask(Scanner sc, TaskController taskController){
        System.out.println("\n ==== Excluindo uma tarefa ====");
        System.out.println("Qual desses cadastros deseja Excluir?");
        taskController.listTasks();

        System.out.print("Digite o Código de Identificação (idTask): ");
        int idTask = Integer.parseInt(sc.next());


        taskController.deleteTask(idTask);

        System.out.println("\n");
        taskController.listTasks();
    }

    private static void findTask(Scanner sc, TaskController taskController){
        System.out.println("\n ==== Buscando por uma tarefa ====");

        System.out.println("Qual desses cadastros deseja Filtrar?");
        taskController.listTasks();

        System.out.print("Digite o Código de Identificação (idTask): ");
        int idTask = Integer.parseInt(sc.next());


        Task task = taskController.findTask(idTask);

        System.out.println("\nCódigo: "+task.getId()+"\nAssunto: "+task.getSubject()+"\nDescrição: "+task.getDescription()+"\nAtivo: " + task.getStatus());

    }
    private static void showTasks(TaskController taskController){
        System.out.println("\n ==== Listando tarefas ====");
        taskController.listTasks();
    }
}