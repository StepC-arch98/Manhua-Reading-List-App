package persistence;

import model.Manhua;
import model.ManhuaList;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Citation: Code sourced and modified from JsonSerializationDemo - JsonReaderTest Class
// Unit tests for JsonReader Class
class JsonReaderTest {
    JsonReader reader;
    ManhuaList manhuaList;

    @Test
    void testReaderNonExistentFile() {
        reader = new JsonReader("./data/noSuchFile.json");
        try {
            ManhuaList manhuaList = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyManhuaList() {
        reader = new JsonReader("./data/testReaderEmptyManhuaList.json");
        try {
            manhuaList = reader.read();
            assertEquals("My Manhua List", manhuaList.getName());
            assertEquals(0, manhuaList.numManhuas());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralManhuaList() {
        reader = new JsonReader("./data/testReaderGeneralManhuaList.json");
        try {
            manhuaList = reader.read();
            assertEquals("My Manhua List", manhuaList.getName());
            ArrayList<Manhua> manhuas = manhuaList.getManhuaList();
            assertEquals(2, manhuas.size());
            checkManhua("The Fatal Kiss", "Manga Sy", manhuas.get(0));
            checkManhua("Aidin", "Zinmanga", manhuas.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    protected void checkManhua(String title, String website, Manhua manhua) {
        assertEquals(title, manhua.getTitle());
        assertEquals(website, manhua.getWebsite());
    }
}
