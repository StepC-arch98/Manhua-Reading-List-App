package model;

// Represents a manhua having a title name and a website name
public class Manhua {
    private String title;                  // the manhua's title name
    private String website;               // the manhua's website source name

    // REQUIRES: manhuaTitle and websiteName have a non-zero length
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

    // EFFECTS: returns string in formatted version
    public String toFormat() {
        return "Title = " + title + ", Website = " + website + "";
    }
}
