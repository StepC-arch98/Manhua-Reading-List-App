package ui;

import java.util.ArrayList;
import java.util.Scanner;

import model.Manhua;
import model.ManhuaList;

// Manhua reading list application
public class ManhuaReadingListApp {
    private Manhua manhua;
    private ManhuaList manhuaList;
    private Scanner input;

    // Code extracted from AccountNotRobust-TellerApp
    // EFFECTS: runs the reading list application
    public ManhuaReadingListApp() {
        runManhuaReadingList();
    }

    // Code extracted from AccountNotRobust-TellerApp
    // MODIFIES: nothing
    // EFFECTS: processes user input
    private void runManhuaReadingList() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processUserCommand(command);
            }
        }

        System.out.println("\nGoodbye!");
    }

    // MODIFIES: this
    // EFFECTS: gets user input and saves the input
    private String getUserInput(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }

    // Code extracted from AccountNotRobust-TellerApp
    // MODIFIES: this
    // EFFECTS: processes user command
    private void processUserCommand(String command) {
        if (command.equals("a")) {
            addManhua();
        } else if (command.equals("r")) {
            removeManhua();
        } else if (command.equals("v")) {
            viewAll();
        } else if (command.equals("s")) {
            searchByTitle();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // Code extracted from AccountNotRobust-TellerApp
    // MODIFIES: this
    // EFFECTS: initializes list
    private void init() {
        manhuaList = new ManhuaList();
        input = new Scanner(System.in);
    }

    // Code extracted from AccountNotRobust-TellerApp
    // EFFECTS: display menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> add");
        System.out.println("\tr -> remove");
        System.out.println("\tv -> view all");
        System.out.println("\ts -> search by title");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: add inputted manhua
    private void addManhua() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input a manhua title: ");
        String manhuaTitle = scanner.nextLine();
        System.out.println("Please input the manhua website: ");
        String manhuaWebsite = scanner.nextLine();
        manhuaList.addManhua(new Manhua(manhuaTitle,manhuaWebsite));
    }

    // REQUIRES: manhua title must exist in the List
    // MODIFIES: this
    // EFFECT: search for manhua with manhua title and return the manhua that matches the manhua title
    private Manhua searchOneManhua(String message) {
        String manhuaTitle = getUserInput(message);
        return manhuaList.getManhua(manhuaTitle);
    }

    // EFFECT: return the manhua in where the manhua title matches the manhua title
    private void searchByTitle() {
        Manhua searchResult = searchOneManhua("Please input the manhua title for search: ");
        if (searchResult == null) {
            System.out.println("No invoice number matches your search.");
        } else {
            System.out.println(searchResult.getFormatted());
        }
    }

    // MODIFIES: this
    // EFFECTS: removes given manhua
    private void removeManhua() {
        Manhua manhua = searchOneManhua("Please input the manhua title to remove: ");
        if (manhua == null) {
            System.out.println("Can't find the manhua.");
            return;
        }
        manhuaList.removeManhua(manhua);
        System.out.println("Manhua successffully deleted!");
    }

    // EFFECTS: shows reading list of manhuas
    private void viewAll() {
        printManhuaList(manhuaList.getManhuaList());
    }

    // EFFECTS: prints each manhua in the list according to the specified format
    private void printManhuaList(ArrayList<Manhua> manhuaList) {
        for (Manhua manhua : manhuaList) {
            System.out.println(manhua.getFormatted());
        }
    }
}

