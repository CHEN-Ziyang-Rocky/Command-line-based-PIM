package info.pim;

import info.pim.constant.Message;
import info.pim.controller.*;
import info.pim.service.PimDataService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String imDataFilePath = "";
        if (args.length > 0) {
            imDataFilePath = args[0];
        }
        boolean loaded = PimDataService.loadPimData(imDataFilePath);
        if (!loaded) {
            return;
        }

        Scanner sc = new Scanner(System.in);
        showCommand();
        while(true) {
            System.out.println();
            System.out.println("----------------------------------------------------------------------");
            printCommand("help", "query list");
            printCommand("quit", "Exit PIM");
            System.out.println("Please input the operation：");
            String command = sc.nextLine();

            if (command.equals("quit")) {
                System.exit(0);
            } else if (command.equals("help")) {
                showCommand();
            } else if (command.startsWith("note ")) {
                NoteController.executeCommand(sc, command);
            } else if (command.startsWith("task ")) {
                TaskController.executeCommand(sc, command);
            } else if (command.startsWith("event ")) {
                EventController.executeCommand(sc, command);
            } else if (command.startsWith("contact ")) {
                ContactController.executeCommand(sc, command);
            } else if (command.trim().startsWith("search")) {
                SearchController.executeCommand(sc, command);
            } else if (command.trim().startsWith("print")) {
                PrintController.executeCommand(sc, command);
            }
        }
    }

    private static void showCommand() {
        System.out.println();
        System.out.println(Message.WELCOME);

        printCommand("note", "list", "List note");
        printCommand("note", "add", "Add note");
        printCommand("note", "edit [id]", "Edit note");
        printCommand("note", "delete [id]", "Delete note");

        printCommand("task", "list", "List task");
        printCommand("task", "add", "Add task");
        printCommand("task", "edit [id]", "Edit task");
        printCommand("task", "delete [id]", "Delete task");

        printCommand("event", "list", "List event");
        printCommand("event", "add", "Add event");
        printCommand("event", "edit [id]", "Edit event");
        printCommand("event", "delete [id]", "Delete event");

        printCommand("contact", "list", "List contact");
        printCommand("contact", "add", "Add contact");
        printCommand("contact", "edit [id]", "Edit contact");
        printCommand("contact", "delete [id]", "Delete contact");

        printCommand("search", "[type|text|time]", "Search");
        printCommand("print", "[id|all]", "Outputer");

    }

    private static void printCommand(String command, String subCommand, String desc) {
        System.out.printf("%-15s %-30s %-25s", command, subCommand, desc);
        System.out.println();
    }

    private static void printCommand(String command, String desc) {
        System.out.printf("%-15s %-30s", command, desc);
        System.out.println();
    }
}
