package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Unit tests for Manhua
class ManhuaTest {
    private Manhua testManhua;

    @BeforeEach
    void runBefore() {
        testManhua = new Manhua("The Fatal Kiss", "Manga Sy");
    }

    @Test
    void testConstructor() {
        assertEquals("The Fatal Kiss", testManhua.getTitle());
        assertEquals("Manga Sy", testManhua.getWebsite());
    }

    @Test
    void testGetFormatted() {
        assertEquals("Title: The Fatal Kiss , Website: Manga Sy", testManhua.getFormatted());

    }
}


