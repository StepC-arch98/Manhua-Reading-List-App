package model;

import exceptions.EmptyTitleException;
import exceptions.EmptyWebsiteException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Unit tests for Manhua Class
class ManhuaTest {
    private Manhua testManhua;

    @Test
    void testConstructorWithoutExceptions() {
        try {
            testManhua = new Manhua("The Fatal Kiss", "Manga Sy");
            assertEquals("The Fatal Kiss", testManhua.getTitle());
            assertEquals("Manga Sy", testManhua.getWebsite());
        } catch (EmptyTitleException emptyTitleException){
            fail("EmptyTitleException should not have been caught");
        } catch (EmptyWebsiteException emptyWebsiteException){
        fail("EmptyWebsiteException should not have been caught");
    }
    }

    @Test
    void testConstructorWithTitleExceptionOfEmptyString() {
        try {
            testManhua = new Manhua("", "Manga Sy");
            fail("EmptyTitleException should have been caught");
        } catch (EmptyTitleException emptyTitleException){
            System.out.println("EmptyTitleException has been caught");
        } catch (EmptyWebsiteException emptyWebsiteException){
            fail("EmptyWebsiteException should not have been caught");
        }
    }

    @Test
    void testConstructorWithWebsiteExceptionOfEmptyString() {
        try {
            testManhua = new Manhua("The Fatal Kiss", "");
            fail("EmptyWebsiteException should have been caught");
        } catch (EmptyTitleException emptyTitleException){
            fail("EmptyTitleException should not have been caught");
        } catch (EmptyWebsiteException emptyWebsiteException){
            System.out.println("EmptyWebsiteException has been caught");
        }
    }

    @Test
    void testConstructorWithBothExceptionsOfEmptyString() {
        try {
            testManhua = new Manhua("", "");
            fail("Exception should have been caught");
        } catch (EmptyTitleException emptyTitleException){
            System.out.println("EmptyTitleException has been caught");
        } catch (EmptyWebsiteException emptyWebsiteException){
            fail("EmptyWebsiteException should not have been caught");
        }
    }


    @Test
    void testToFormat() throws EmptyTitleException, EmptyWebsiteException {
        testManhua = new Manhua("The Fatal Kiss", "Manga Sy");
        assertEquals("Title = The Fatal Kiss, Website = Manga Sy", testManhua.toFormat());
        assertTrue( testManhua.toFormat().contains("Title = The Fatal Kiss, Website = Manga Sy"));
    }
}


