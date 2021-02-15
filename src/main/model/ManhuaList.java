package model;

import java.util.ArrayList;
import java.util.List;

// Represents a list of manhuas
public class ManhuaList {
    private List<Manhua> manhua;

    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public ManhuaList() {
        manhua = new ArrayList<>();
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public void addManhua(Manhua m) {
        if (!contains(m)) {
            manhua.add(m);
        }
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public void removeManhua(Manhua m) {
        manhua.remove(m);

    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS:
    public boolean contains(Manhua m) {
        return manhua.contains(m);
    }

    // EFFECTS:
    public int size() {
        return manhua.size();
    }
}

