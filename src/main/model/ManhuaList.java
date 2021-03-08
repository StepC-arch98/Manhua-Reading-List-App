package model;

import persistence.Writable;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

// Represents a reading list of manhuas
public class ManhuaList implements Writable {
    private String name;
    private ArrayList<Manhua> manhuaList;

    // EFFECTS: constructs each new manhua list with a name and as an empty list of manhuas
    public ManhuaList(String name) {
        this.name = name;
        manhuaList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // EFFECTS: returns list of manhuas in this manhua list
    public ArrayList<Manhua> getManhuaList() {
        return manhuaList;
    }

    // MODIFIES: this
    // EFFECTS: adds given manhua if it is not in the manhua list, otherwise does nothing
    public void addManhua(Manhua manhua) {
        if (!containsManhua(manhua.getTitle(), manhua.getWebsite())) {
            manhuaList.add(manhua);
        }
    }

    // MODIFIES: this
    // EFFECTS: removes given manhua if it is in the manhua list
    public void removeManhua(Manhua manhua) {
        manhuaList.remove(manhua);
    }

    // REQUIRES: title and website have a non-zero length
    // EFFECTS: returns true if there is a manhua with given title and website contained in the manhua list,
    //          otherwise returns false
    public boolean containsManhua(String title, String website) {
        for (Manhua manhua : manhuaList) {
            if ((manhua.getTitle().equals(title)) & manhua.getWebsite().equals(website)) {
                return manhuaList.contains(manhua);
            }
        }
        return false;
    }

    // MODIFIES: title has a non-zero length
    // EFFECTS: returns the manhua with given title name, otherwise returns null
    public Manhua getManhua(String title) {
        for (Manhua manhua : manhuaList) {
            if (manhua.getTitle().equals(title)) {
                return manhua;
            }
        }
        return null;
    }

    // EFFECTS: returns number of manhuas in the manhua list
    public int numManhuas() {
        return manhuaList.size();
    }

    // Citation: Code sourced and modified from JsonSerializationDemo - WorkRoom Class
    // EFFECTS: see interface Writable
    @Override
    public JSONObject manhuaToJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("manhuas", manhuasToJson());
        return json;
    }

    // Citation: Code sourced and modified from JsonSerializationDemo - WorkRoom Class
    // EFFECTS: returns manhuas in this manhua list as a JSON array
    private JSONArray manhuasToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Manhua manhua : manhuaList) {
            jsonArray.put(manhua.manhuaToJson());
        }

        return jsonArray;
    }
}

