package model;

import persistence.Writable;

import org.json.JSONObject;

// Represents a manhua having a title name and a website name
public class Manhua implements Writable {
    private String title;                  // the manhua's title name
    private String website;               // the manhua's website source name

    // REQUIRES: manhuaTitle and websiteName have a non-zero length
    // EFFECTS: constructs a manhua with title set to manhuaTitle and website set to websiteName
    public Manhua(String manhuaTitle, String websiteName) {
        this.title = manhuaTitle;
        this.website = websiteName;
    }

    // EFFECTS: returns manhua's title name
    public String getTitle() {
        return title;
    }

    // EFFECTS: returns manhua's website source name
    public String getWebsite() {
        return website;
    }

    // EFFECTS: returns string in formatted version
    public String toFormat() {
        return "Title = " + title + ", Website = " + website + "";
    }

    // Citation: Code sourced and modified from JsonSerializationDemo - Thingy Class
    // EFFECTS: see interface Writable
    @Override
    public JSONObject manhuaToJson() {
        JSONObject json = new JSONObject();
        json.put("title", title);
        json.put("website", website);
        return json;
    }
}
