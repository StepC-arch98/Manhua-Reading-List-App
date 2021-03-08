package persistence;

import model.Manhua;
import model.ManhuaList;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Citation: Code sourced and modified from JsonSerializationDemo - JsonReader Class
// Represents a reader that reads manhua list from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads manhua list from file and returns it;
    //          throws IOException if an error occurs reading data from file
    public ManhuaList read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseManhuaList(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }
        return contentBuilder.toString();
    }

    // EFFECTS: parses manhua list from JSON object and returns it
    private ManhuaList parseManhuaList(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        ManhuaList manhuaList = new ManhuaList(name);
        addManhuas(manhuaList, jsonObject);
        return manhuaList;
    }

    // MODIFIES: manhuaList
    // EFFECTS: parses manhuas from JSON object and adds them to manhua list
    private void addManhuas(ManhuaList manhuaList, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("manhuas");
        for (Object json : jsonArray) {
            JSONObject nextManhua = (JSONObject) json;
            addManhua(manhuaList, nextManhua);
        }
    }

    // MODIFIES: manhuaList
    // EFFECTS: parses manhua from JSON object and adds it to manhua list
    private void addManhua(ManhuaList manhuaList, JSONObject jsonObject) {
        String title = jsonObject.getString("title");
        String website = String.valueOf(jsonObject.getString("website"));
        Manhua manhua = new Manhua(title, website);
        manhuaList.addManhua(manhua);
    }
}
