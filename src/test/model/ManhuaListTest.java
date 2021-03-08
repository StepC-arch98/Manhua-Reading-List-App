package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Unit tests for ManhuaList Class
class ManhuaListTest {
    private ManhuaList testManhuaList;
    private    Manhua manhua1;
    private    Manhua manhua2;
    private    Manhua manhua3;

    @BeforeEach
    void runBefore() {
        testManhuaList = new ManhuaList("Estephany's Manhua List");
        manhua1 = new Manhua("The Fatal Kiss","Manga Sy");
        manhua2 = new Manhua("Aidin", "Zinmanga");
        manhua3 = new Manhua("Once More", "WebComics");
    }

    @Test
    void testConstructor() {
        assertEquals(0,testManhuaList.numManhuas());
    }

    @Test
    void testGetName() {
        assertEquals("Estephany's Manhua List", testManhuaList.getName());
    }

    @Test
    void testGetManhuaList() {
        assertEquals(0, testManhuaList.getManhuaList().size());
        testManhuaList.addManhua(manhua1);
        testManhuaList.addManhua(manhua2);
        testManhuaList.addManhua(manhua3);
        assertEquals(3, testManhuaList.getManhuaList().size());
    }

    @Test
    void testAddManhua() {
        assertEquals(0, testManhuaList.numManhuas());
        testManhuaList.addManhua((manhua1));
        assertEquals(1, testManhuaList.numManhuas());
        assertTrue(testManhuaList.containsManhua("The Fatal Kiss", "Manga Sy"));
    }

    @Test
    void testAddManhuaDouble() {
        assertEquals(0, testManhuaList.numManhuas());
        testManhuaList.addManhua((manhua1));
        testManhuaList.addManhua((manhua1));
        assertEquals(1, testManhuaList.numManhuas());
        assertTrue(testManhuaList.containsManhua(manhua1.getTitle(), manhua1.getWebsite()));
    }

    @Test
    void testRemoveManhua() {
        testManhuaList.addManhua(manhua1);
        testManhuaList.addManhua(manhua2);
        testManhuaList.removeManhua(manhua2);
        assertEquals(1,testManhuaList.numManhuas());
        assertTrue(testManhuaList.containsManhua(manhua1.getTitle(), manhua1.getWebsite()));
        assertFalse(testManhuaList.containsManhua(manhua2.getTitle(), manhua2.getWebsite()));
    }

    @Test
    void testContainsManhuaWithEmptyList() {
        assertEquals(0, testManhuaList.numManhuas());
        assertFalse(testManhuaList.containsManhua(manhua1.getTitle(), manhua1.getWebsite()));
    }

    @Test
    void testContainsManhuaWithManhuaInList() {
        testManhuaList.addManhua(manhua1);
        testManhuaList.addManhua(manhua2);
        assertEquals(2, testManhuaList.numManhuas());
        assertTrue(testManhuaList.containsManhua(manhua2.getTitle(), manhua2.getWebsite()));
        assertTrue(testManhuaList.containsManhua(manhua1.getTitle(),manhua1.getWebsite()));
        assertFalse(testManhuaList.containsManhua(manhua3.getTitle(), manhua3.getWebsite()));
    }

    @Test
    void testContainsManhuaWithAddedAndRemovedManhua() {
        testManhuaList.addManhua(manhua1);
        testManhuaList.addManhua(manhua2);
        testManhuaList.addManhua(manhua3);
        assertEquals(3, testManhuaList.numManhuas());
        testManhuaList.removeManhua(manhua2);
        assertEquals(2, testManhuaList.numManhuas());
        assertFalse(testManhuaList.containsManhua(manhua2.getTitle(), manhua2.getWebsite()));
        assertTrue(testManhuaList.containsManhua(manhua3.getTitle(), manhua3.getWebsite()));
        assertTrue(testManhuaList.containsManhua(manhua1.getTitle(),manhua1.getWebsite()));    }

    @Test
    void testGetManhuaWithEmptyList() {
        assertEquals(0, testManhuaList.numManhuas());
        assertNull(testManhuaList.getManhua(manhua1.getTitle()));
    }

    @Test
    void testGetManhuaWithManhuaInList() {
        testManhuaList.addManhua(manhua1);
        testManhuaList.addManhua(manhua2);
        assertEquals(2, testManhuaList.numManhuas());
        assertEquals(manhua2, testManhuaList.getManhua(manhua2.getTitle()));
        assertEquals(manhua1, testManhuaList.getManhua(manhua1.getTitle()));
        assertNull(testManhuaList.getManhua("the fatal kiss"));
    }

    @Test
    void testGetManhuaWithAddedAndRemovedManhua() {
        testManhuaList.addManhua(manhua1);
        testManhuaList.addManhua(manhua2);
        testManhuaList.addManhua(manhua3);
        assertEquals(3, testManhuaList.numManhuas());
        testManhuaList.removeManhua(manhua2);
        assertEquals(2, testManhuaList.numManhuas());
        assertNull(testManhuaList.getManhua(manhua2.getTitle()));
        assertEquals(manhua3, testManhuaList.getManhua(manhua3.getTitle()));
        assertEquals(manhua1, testManhuaList.getManhua(manhua1.getTitle()));
        assertNull(testManhuaList.getManhua("once more"));
    }

    @Test
    void testAmount() {
        assertEquals(0, testManhuaList.numManhuas());
        testManhuaList.addManhua(manhua1);
        testManhuaList.addManhua(manhua2);
        assertEquals(2, testManhuaList.numManhuas());
        testManhuaList.addManhua(manhua1);
        testManhuaList.addManhua(manhua2);
        testManhuaList.addManhua(manhua1);
        testManhuaList.addManhua(manhua2);
        assertEquals(2, testManhuaList.numManhuas());
    }
}
