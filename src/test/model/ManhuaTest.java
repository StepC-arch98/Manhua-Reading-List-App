package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManhuaTest {
    private Manhua testManhua;

    @BeforeEach
    void runBefore() {
        testManhua = new Manhua("The Fatal Kiss", "Manga Sy",
                "Currently Reading");
    }

    @Test
    void testConstructorInitialStatus() {
        testManhua = new Manhua ("Aidin", "Zinmanga", "New");
        assertEquals("Aidin", testManhua.getName());
        assertEquals("Zinmanga", testManhua.getWebsite());
        assertEquals("To Be Read", testManhua.getStatus());
    }

    @Test
    void testConstructorStatus_2() {
        testManhua = new Manhua ("Aidin", "Zinmanga", "Finished");
        assertEquals("Aidin", testManhua.getName());
        assertEquals("Zinmanga", testManhua.getWebsite());
        assertEquals("Finished", testManhua.getStatus());
    }

    @Test
    void testConstructorStatus_3() {
        testManhua = new Manhua ("Aidin", "Zinmanga", "Currently Reading");
        assertEquals("Aidin", testManhua.getName());
        assertEquals("Zinmanga", testManhua.getWebsite());
        assertEquals("Currently Reading", testManhua.getStatus());
    }

    @Test
    void testToString() {
        assertTrue( testManhua.toString().contains("name = The Fatal Kiss, website = Manga Sy, " +
                "status = Currently Reading"));
    }
}


