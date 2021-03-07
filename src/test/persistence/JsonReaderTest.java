package persistence;

import model.Manhua;
import model.ManhuaList;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

// Code sourced from JsonSerializationDemo - JsonReaderTest
// Unit tests for JsonReader Class
class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            ManhuaList ml = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyManhuaList() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyManhuaList.json");
        try {
            ManhuaList ml = reader.read();
            assertEquals("My manhua list", ml.getName());
            assertEquals(0, ml.amount());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralManhuaList() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralManhuaList.json");
        try {
            ManhuaList ml = reader.read();
            assertEquals("My manhua list", ml.getName());
            ArrayList<Manhua> manhuaList = ml.getManhuaList();
            assertEquals(2, manhuaList.size());
            checkManhua("The Fatal Kiss", "Manga Sy", manhuaList.get(0));
            checkManhua("Aidin", "Zinmanga", manhuaList.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
