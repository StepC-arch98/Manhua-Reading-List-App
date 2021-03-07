package model;

import java.util.ArrayList;

// Represents a reading list of manhuas
public class ManhuaList {
    private ArrayList<Manhua> manhuaList;

    // EFFECTS: initializes each new manhua list as an empty list
    public ManhuaList() {
        manhuaList = new ArrayList<>();
    }

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
    public int amount() {
        return manhuaList.size();
    }
}

