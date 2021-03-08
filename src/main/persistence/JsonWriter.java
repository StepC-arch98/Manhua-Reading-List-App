package persistence;

import model.ManhuaList;

import java.io.*;

import org.json.JSONObject;

// Citation: Code sourced and modified from JsonSerializationDemo - JsonWriter Class
// Represents a writer that writes JSON representation of manhua list to file
public class JsonWriter {
    private static final int TAB = 6;                    // indentation space for Json file
    private PrintWriter writer;                          // Json file writer
    private String destination;                          // destination file link

    // REQUIRES: destination has a non-zero length
    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of manhua list to file
    public void write(ManhuaList manhuaList) {
        JSONObject json = manhuaList.manhuaToJson();
        saveToFile(json.toString(TAB));
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        writer.print(json);
    }
}
