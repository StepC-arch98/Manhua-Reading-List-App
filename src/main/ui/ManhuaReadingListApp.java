package ui;

import model.Manhua;
import model.ManhuaList;

import java.util.Scanner;

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
    // MODIFIES: this
    // EFFECTS: processes user input
    private void runManhuaReadingList() {
        boolean keepGoing = true;
        String command = null;

        initialization();

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

    // Code extracted from AccountNotRobust-TellerApp
    // MODIFIES: this
    // EFFECTS: processes user command
    private void processUserCommand(String command) {
        if (command.equals("a")) {
            addManhua();
        } else if (command.equals("r")) {
            removeManhua();
        } else if (command.equals("s")) {
            searchByTitle();
        } else if (command.equals("v")) {
            viewList();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // Code extracted from AccountNotRobust-TellerApp
    // MODIFIES: this
    // EFFECTS: initializes manhua reading list and scanner
    private void initialization() {
        manhuaList = new ManhuaList();
        input = new Scanner(System.in);
    }

    // Code extracted from AccountNotRobust-TellerApp
    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> add");
        System.out.println("\tr -> remove");
        System.out.println("\ts -> search by title");
        System.out.println("\tv -> view list");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: conducts command to add manhua
    private void addManhua() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a manhua title: ");
        String manhuaTitle = input.nextLine();
        System.out.println("Enter the corresponding website: ");
        String manhuaWebsite = input.nextLine();
        manhuaList.addManhua(new Manhua(manhuaTitle, manhuaWebsite));
        System.out.println("Manhua successfully added!");
    }

    // MODIFIES: this
    // EFFECTS: conducts command to remove manhua
    private void removeManhua() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the manhua's title to remove: ");
        String manhuaTitle = input.nextLine();
        Manhua manhua = manhuaList.getManhua(manhuaTitle);
        if (manhua == null) {
            System.out.println("Cannot find the manhua to remove.");
        } else {
            manhuaList.removeManhua(manhua);
            System.out.println("Manhua successfully removed!");
        }
    }

    // EFFECTS: conducts and returns search result prompted by user input
    private void searchByTitle() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the manhua's title to search: ");
        String manhuaTitle = input.nextLine();
        Manhua manhua = manhuaList.getManhua(manhuaTitle);
        if (manhua == null) {
            System.out.println("No manhua matches your search.");
        } else {
            System.out.println("Found: " + manhua.toFormat());
        }
    }

    // EFFECTS: shows/prints reading list of manhuas to the screen
    private void viewList() {
        for (Manhua manhua : manhuaList.getManhuaList()) {
            System.out.println(manhua.toFormat());
        }
    }
}
