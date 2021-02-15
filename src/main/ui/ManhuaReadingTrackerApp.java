package ui;

import java.util.Scanner;
import java.util.List;

import model.Manhua;
import model.ManhuaList;

// Manhua reading tracker application
public class ManhuaReadingTrackerApp {

    // EFFECTS: runs the tracking application
    public ManhuaReadingTrackerApp() {
        runManhuaReadingTracker();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runManhuaReadingTracker() {
        while (true) {
            displayMenu();;
            String comm = null;
            if (comm == "a") {
                addManhua();
            } else if (comm == "r") {
                editWebsite();
            } else if (comm == "s") {
                editStatus();
            } else if (comm == "p") {
                printManhua();
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("a")) {
            addManhua();
        } else if (command.equals("r")) {
            editWebsite();
        } else if (command.equals("c")) {
            editStatus();
        } else if (command.equals("p")) {
            printManhua();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("Add Manhua");
        System.out.println("Remove Manhua");
        System.out.println("Change Reading Status");
        System.out.println("Print Manhua List");
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void addManhua() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Manhua: ");
        String manhuaName = scanner.nextLine();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void editWebsite() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Website: ");
        String manhuawebsite = scanner.nextLine();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void printManhua(List<Manhua> manhuaList) {
        for (Manhua manhua: manhuaList) {
            System.out.println(manhua.toString());
        }
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void editStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Status: ");
    String manhuaStatus = scanner.nextLine();
    }
}
