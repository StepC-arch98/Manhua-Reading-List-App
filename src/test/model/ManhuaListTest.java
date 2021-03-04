package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Unit tests for ManhuaList
class ManhuaListTest {
    private ManhuaList testManhuaList;
        Manhua manhua1;
        Manhua manhua2;
        Manhua manhua3;

    @BeforeEach
    void runBefore() {
        testManhuaList = new ManhuaList();
        manhua1 = new Manhua("The Fatal Kiss","Manga Sy");
        manhua2 = new Manhua("Aidin", "Zinmanga");
        manhua3 = new Manhua("Once More", "WebComics");
    }

    @Test
    void testConstructor() {
        assertEquals(0,testManhuaList.amount());
    }

    @Test
    void testAddManhua() {
        assertEquals(0, testManhuaList.amount());
        testManhuaList.addManhua((manhua1));
        assertEquals(1, testManhuaList.amount());
    }

    @Test
    void testAddManhuaDouble() {
        assertEquals(0, testManhuaList.amount());
        testManhuaList.addManhua((manhua1));
        testManhuaList.addManhua((manhua1));
        assertEquals(1, testManhuaList.amount());
    }

    @Test
    void testRemoveManhua() {
        testManhuaList.addManhua(manhua1);
        testManhuaList.addManhua(manhua2);
        testManhuaList.removeManhua(manhua2);
        assertEquals(1,testManhuaList.amount());
        assertTrue(testManhuaList.containsManhua(manhua1.getTitle(), manhua1.getWebsite()));
        assertFalse(testManhuaList.containsManhua(manhua2.getTitle(), manhua2.getWebsite()));
    }

    @Test
    void testGetManhuaList() {
        testManhuaList.addManhua(manhua1);
        testManhuaList.addManhua(manhua2);
        testManhuaList.addManhua(manhua3);
        assertEquals(3, testManhuaList.amount());
    }
    @Test
    void testContainsManhuaWithEmptyList() {
        assertEquals(0, testManhuaList.amount());
        assertFalse(testManhuaList.containsManhua(manhua1.getTitle(), manhua1.getWebsite()));
    }

    @Test
    void testContainsManhuaWithManhuaInList() {
        testManhuaList.addManhua(manhua1);
        testManhuaList.addManhua(manhua2);
        assertEquals(2, testManhuaList.amount());
        assertTrue(testManhuaList.containsManhua(manhua2.getTitle(), manhua2.getWebsite()));
        assertTrue(testManhuaList.containsManhua(manhua1.getTitle(),manhua1.getWebsite()));
    }

    @Test
    void testContainsManhuaWithAddedAndRemovedManhua() {
        testManhuaList.addManhua(manhua1);
        testManhuaList.addManhua(manhua2);
        testManhuaList.addManhua(manhua3);
        testManhuaList.removeManhua(manhua2);
        assertFalse(testManhuaList.containsManhua(manhua2.getTitle(), manhua2.getWebsite()));
    }

    @Test
    void testGetManhuaWithEmptyList() {
        assertEquals(0, testManhuaList.amount());
        assertEquals(null, testManhuaList.getManhua(manhua1.getTitle()));
    }

    @Test
    void testGetManhuaWithManhuaInList() {
        testManhuaList.addManhua(manhua1);
        testManhuaList.addManhua(manhua2);
        assertEquals(2, testManhuaList.amount());
        assertEquals(manhua2, testManhuaList.getManhua(manhua2.getTitle()));
        assertEquals(manhua1, testManhuaList.getManhua(manhua1.getTitle()));
        assertEquals(null, testManhuaList.getManhua("the fatal kiss"));
    }

    @Test
    void testGetManhuaWithAddedAndRemovedManhua() {
        testManhuaList.addManhua(manhua1);
        testManhuaList.addManhua(manhua2);
        testManhuaList.addManhua(manhua3);
        testManhuaList.removeManhua(manhua2);
        assertEquals(null, testManhuaList.getManhua(manhua2.getTitle()));
    }

    @Test
    void testAmount() {
        assertEquals(0, testManhuaList.amount());
        testManhuaList.addManhua(manhua1);
        testManhuaList.addManhua(manhua2);
        assertEquals(2, testManhuaList.amount());
        testManhuaList.addManhua(manhua1);
        testManhuaList.addManhua(manhua2);
        testManhuaList.addManhua(manhua1);
        testManhuaList.addManhua(manhua2);
        assertEquals(2, testManhuaList.amount());
    }

}
