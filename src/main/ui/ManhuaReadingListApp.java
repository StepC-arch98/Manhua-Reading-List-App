package ui;

import exceptions.EmptyTitleException;
import exceptions.EmptyWebsiteException;
import model.Manhua;
import model.ManhuaList;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// Manhua reading list application
public class ManhuaReadingListApp {
    private static final String JSON_STORE = "./data/manhualist.json";
    private Scanner input;                          // input reader
    private ManhuaList manhuaList;                  // list of manhuas
    private JsonWriter jsonWriter;                  // Json file writer or file saver
    private JsonReader jsonReader;                  // Json file reader or file loader

    // Citation: Code sourced and modified from AccountNotRobust - TellerApp Class and
    //           JsonSerializationDemo - WorkRoomApp Class
    // EFFECTS: constructs manhua list and runs the reading list application
    public ManhuaReadingListApp() {
        input = new Scanner(System.in);
        manhuaList = new ManhuaList("Estephany's Manhua List");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runManhuaReadingList();
    }

    // Citation: Code sourced and modified from AccountNotRobust - TellerApp Class
    // MODIFIES: this
    // EFFECTS: processes user input
    private void runManhuaReadingList() {
        boolean keepGoing = true;
        String command = null;

        input = new Scanner(System.in);

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

    // Citation: Code sourced and modified from AccountNotRobust - TellerApp Class
    // REQUIRES: command cannot be an empty string
    // MODIFIES: this
    // EFFECTS: processes user command
    private void processUserCommand(String command) {
        if (command.equals("a")) {
            addManhua();
        } else if (command.equals("r")) {
            removeManhua();
        } else if (command.equals("t")) {
            searchByTitle();
        } else if (command.equals("v")) {
            viewList();
        } else if (command.equals("s")) {
            saveManhuaList();
        } else if (command.equals("l")) {
            loadManhuaList();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // Citation: Code sourced and modified from AccountNotRobust - TellerApp Class
    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> add");
        System.out.println("\tr -> remove");
        System.out.println("\tt -> search by title");
        System.out.println("\tv -> view list");
        System.out.println("\ts -> save manhua list to file");
        System.out.println("\tl -> load manhua list from file");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: conducts command to add manhua
    private void addManhua() {
        input = new Scanner(System.in);
        System.out.println("Enter a manhua title: ");
        String manhuaTitle = input.nextLine();
        System.out.println("Enter the corresponding website: ");
        String manhuaWebsite = input.nextLine();
        try {
            manhuaList.addManhua(new Manhua(manhuaTitle, manhuaWebsite));
            System.out.println("Manhua successfully added!");
        } catch (EmptyTitleException e) {
            System.out.println("No manhua's title inputted");
        } catch (EmptyWebsiteException e) {
            System.out.println("No manhua's website inputted");
        }
    }

    // MODIFIES: this
    // EFFECTS: conducts command to remove manhua
    private void removeManhua() {
        input = new Scanner(System.in);
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
        input = new Scanner(System.in);
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

    // Citation: Code sourced and modified from JsonSerializationDemo - WorkRoomApp Class
    // EFFECTS: saves the manhua list to file
    private void saveManhuaList() {
        try {
            jsonWriter.open();
            jsonWriter.write(manhuaList);
            jsonWriter.close();
            System.out.println("Saved " + manhuaList.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // Citation: Code sourced and modified from JsonSerializationDemo - WorkRoomApp Class
    // MODIFIES: this
    // EFFECTS: loads manhua list from file
    private void loadManhuaList() {
        try {
            manhuaList = jsonReader.read();
            System.out.println("Loaded " + manhuaList.getName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}

