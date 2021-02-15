package model;

import model.ManhuaList;
import model.Manhua.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//Unit tests for ManhuaList
public class ManhuasListTest {
    private ManhuaList list;
        Manhua m1;
        Manhua m2;
        Manhua m3;

    @BeforeEach
    public void runBefore() {
        list = new ManhuaList();
        m1 = new Manhua("The Fatal Kiss","Manga Sy", "Currently Reading");
        m2 = new Manhua("Aidin", "Zinmanga", "Finished");
        m3 = new Manhua("Flowers", "MangaToon", "To Be Read");
    }

    @Test
    public void testContainsManhua() {
        assertFalse(list.contains(m1));
        list.addManhua(m1);
        assertTrue(list.contains(m1));
    }

    @Test
    public void testDouble() {
        list.addManhua(m2);
        list.addManhua(m2);

        assertTrue(list.contains(m2));
        assertEquals(true, list.contains(m2));
    }

    @Test
    public void testRemoveManhua() {
        list.addManhua(m3);
        list.removeManhua(m3);
        assertFalse(list.contains(m3));
        assertEquals(false, list.contains(null));
    }
}
