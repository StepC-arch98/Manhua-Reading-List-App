package persistence;

import model.Manhua;
import model.ManhuaList;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

// Code sourced from JsonSerializationDemo - JsonWriterTest
// Unit tests for JsonWriter Class
class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            ManhuaList ml = new ManhuaList("My manhua list");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyManhuaList() {
        try {
            ManhuaList ml = new ManhuaList("My manhua list");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyManhuaList.json");
            writer.open();
            writer.write(ml);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyManhuaList.json");
            ml = reader.read();
            assertEquals("My manhua list", ml.getName());
            assertEquals(0, ml.amount());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralManhuaList() {
        try {
            ManhuaList ml = new ManhuaList("My manhua list");
            ml.addManhua(new Manhua("Aidin", "Webcomics"));
            ml.addManhua(new Manhua("The Fatal Kiss", "Manga Sy"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralManhuaList.json");
            writer.open();
            writer.write(ml);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralManhuaList.json");
            ml = reader.read();
            assertEquals("My manhua list", ml.getName());
            ArrayList<Manhua> manhuaList = ml.getManhuaList();
            assertEquals(2, manhuaList.size());
            checkManhua("Aidin", "Webcomics", manhuaList.get(0));
            checkManhua("The Fatal Kiss", "Manga Sy", manhuaList.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
