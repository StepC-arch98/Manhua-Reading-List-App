package model;

// Represents a manhua having a reading status and rating (in numbers from 1 to 5)
public class Manhua {
    private String name;                  // manhua name
    private String website;               // the manhua website name
    private String status;                // the reading status of a manhua

    /*
     * REQUIRES:
     * MODIFIES:
     * EFFECTS:
     */
    public Manhua(String manhuaName, String websiteName, String initialReadingStatus) {
        name = manhuaName;
        website = websiteName;
        if (initialReadingStatus != "Currently Reading" && initialReadingStatus != "Finished") {
            status = "To Be Read";
        } else {
            status = initialReadingStatus;
        }
    }

    public String getName() {
        return name;
    }

    public String getWebsite() {
        return website;
    }

    public String getStatus() {
        return status;
    }

    /*
     * REQUIRES:
     * MODIFIES:
     * EFFECTS:
     */
    public String editStatus(String changedStatus) {
        status = changedStatus;
        return status;
    }

    /*
     * REQUIRES:
     * MODIFIES:
     * EFFECTS:
     */
    @Override
    public String toString() {
        return "[ name = " + name + ", website = " + website + ", status = " + status + "]";
    }
}
