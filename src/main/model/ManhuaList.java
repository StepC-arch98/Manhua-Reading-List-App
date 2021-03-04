package model;

import java.util.ArrayList;
import java.util.Collections;

// Represents a reading list that keeps track of manhuas
public class ManhuaList {
    private ArrayList<Manhua> manhuaList;

    // REQUIRES: nothing
    // MODIFIES: nothing
    // EFFECTS: initializes each new manhuaList as an empty list
    public ManhuaList() {
        manhuaList = new ArrayList<>();
    }

    // REQUIRES: nothing
    // MODIFIES: this
    // EFFECTS: add given manhua if it is not in the manhuaList, otherwise do nothing
    public void addManhua(Manhua manhua) {
        if (!containsManhua(manhua.getTitle(), manhua.getWebsite())) {
            manhuaList.add(manhua);
        }
    }

    // REQUIRES: nothing
    // MODIFIES: this
    // EFFECTS: remove given manhua if it is in the manhuaList, otherwise do nothing
    public void removeManhua(Manhua manhua) {
        manhuaList.remove(manhua);
    }

    public ArrayList<Manhua> getManhuaList() {
        return manhuaList;
    }

    // REQUIRES: nothing
    // MODIFIES: nothing
    // EFFECTS: check if the given manhua is in the manhuaList
    public boolean containsManhua(String manhuaTitle, String website) {
        for (Manhua manhua : manhuaList) {
            if ((manhua.getTitle().equals(manhuaTitle)) & manhua.getWebsite().equals(website)) {
                return manhuaList.contains(manhua);
            }
        }
        return false;
    }


    // REQUIRES: manhuaTitle is case sensitive
    // MODIFIES: nothing
    // EFFECTS: given the title of a manhua return the Manhua with given name, otherwise return null
    public Manhua getManhua(String manhuaTitle) {
        for (Manhua m : manhuaList) {
            if (m.getTitle().equals(manhuaTitle)) {
                return m;
            }
        }
        return null;
    }

    // REQUIRES: nothing
    // MODIFIES: nothing
    // EFFECTS: return number of manhuas  in the list
    public int amount() {
        return manhuaList.size();
    }
}

