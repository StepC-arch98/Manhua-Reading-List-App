package model;

// Represents a manhua having a title name and a website name
public class Manhua {
    private String title;                  // the manhua's title
    private String website;               // the manhua's website name

    // REQUIRES: manhuaTitle and websiteName have a non-zero length
    // MODIFIES: nothing
    // EFFECTS: constructs a manhua with title set to manhuaTitle and website set to websiteName
    public Manhua(String manhuaTitle, String websiteName) {
        this.title = manhuaTitle;
        this.website = websiteName;
    }

    public String getTitle() {
        return title;
    }

    public String getWebsite() {
        return website;
    }

    // EFFECTS: formats string to given format
    public String getFormatted() {
        String format = "Title: %s , Website: %s";
        return String.format(format, title, website);
    }
}
