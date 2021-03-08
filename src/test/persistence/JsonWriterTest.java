package persistence;

import model.Manhua;
import model.ManhuaList;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Citation: Code sourced and modified from JsonSerializationDemo - JsonWriterTest Class
// Unit tests for JsonWriter Class
class JsonWriterTest extends JsonTest {
    ManhuaList manhuaList;

    @BeforeEach
    void runBefore() {
        manhuaList = new ManhuaList("My Manhua List");
    }
//
//    @Test
//    void testWriterInvalidFile() {
//        //try {
//            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
//            writer.open();
//            fail("IOException was expected");
////        } catch (IOException e) {
////            // pass
////        }
//    }

    @Test
    void testWriterEmptyManhuaList() {
        try {
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyManhuaList.json");
            writer.open();
            writer.write(manhuaList);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyManhuaList.json");
            manhuaList = reader.read();
            assertEquals("My Manhua List", manhuaList.getName());
            assertEquals(0, manhuaList.numManhuas());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralManhuaList() {
        try {
            manhuaList.addManhua(new Manhua("Aidin", "Webcomics"));
            manhuaList.addManhua(new Manhua("The Fatal Kiss", "Manga Sy"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralManhuaList.json");
            writer.open();
            writer.write(manhuaList);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralManhuaList.json");
            manhuaList = reader.read();
            assertEquals("My Manhua List", manhuaList.getName());
            ArrayList<Manhua> manhuas = manhuaList.getManhuaList();
            assertEquals(2, manhuas.size());
            checkManhua("Aidin", "Webcomics", manhuas.get(0));
            checkManhua("The Fatal Kiss", "Manga Sy", manhuas.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
