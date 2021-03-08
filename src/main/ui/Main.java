package ui;

import java.io.FileNotFoundException;

public class Main {
    // Citation: Code sourced and modified from JsonSerializationDemo - Main Class
    public static void main(String[] args) {
        try {
            new ManhuaReadingListApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }
}
